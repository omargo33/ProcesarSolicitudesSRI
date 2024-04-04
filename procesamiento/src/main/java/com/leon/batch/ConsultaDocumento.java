package com.leon.batch;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

@Getter
@Setter
@Slf4j
public class ConsultaDocumento {

    String respuestaSolicitud;
    String estadoSolicitud;

    public void procesarSolicitud(String url, String token, String usuario, String credencial, String claveAcceso) {

        try {
            URL apiUrl = new URL(url + "/" + claveAcceso);

            // Abrir conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + token);

            String credencialEncode = usuario + ":" + credencial;
            connection.setRequestProperty("X-SRI-Credentials",
                    Base64.getEncoder().encodeToString(credencialEncode.getBytes(StandardCharsets.UTF_8)));

            // Habilitar el envío de datos
            connection.setDoOutput(true);

            // Obtener el código de respuesta
            int responseCode = connection.getResponseCode();
            log.info("Código de respuesta: {}", responseCode);
            setEstadoSolicitud(String.valueOf(responseCode));

            // Leer la respuesta del servicio
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();

            // Imprimir la respuesta
            log.info("Respuesta del servicio: {}", response.toString());

            setRespuestaSolicitud(response.toString());            
        } catch (IOException e) {
            log.error("Error en la consulta de documentos {}",e.toString());
        }

    }

    public void analizarRespuesta(String json, String usuarioBD, String credencialBD, String baseDatos) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            //Object jsonObject = new JSONObject(json);

            // Obtenemos el valor del campo "status"
            String status = jsonObject.getString("status");
            log.info("Status: {}", status);

            // Obtenemos el array de objetos "data"
            JSONArray dataArray = jsonObject.getJSONArray("data");

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject dataObject = dataArray.getJSONObject(i);

                // Obtenemos los valores de los campos dentro de cada objeto "data"
                int documentId = dataObject.getInt("documentId");
                String rucIssuer = dataObject.getString("rucIssuer");
                String commercialName = dataObject.getString("commercialName");
                String socialNameIssuer = dataObject.getString("socialNameIssuer");
                String issuedAt = dataObject.getString("issuedAt");
                String establishment = dataObject.getString("establishment");
                String pointIssue = dataObject.getString("pointIssue");
                String sequence = dataObject.getString("sequence");
                String documentType = dataObject.getString("documentType");
                int documentTypeId = dataObject.getInt("documentTypeId");
                String issuedAtFormatted = dataObject.getString("issuedAtFormatted");
                String accessKey = dataObject.getString("accessKey");
                double totalValueWithoutTaxes = dataObject.getDouble("totalValueWithoutTaxes");
                double tip = dataObject.getDouble("tip");
                double totalDiscount = dataObject.getDouble("totalDiscount");
                double totalAmount = dataObject.getDouble("totalAmount");
                String taxpayerId = dataObject.getString("taxpayerId");

                // Verificar si el registro ya existe
                boolean registroExistente = false;

                try (java.sql.Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://50.31.188.7/" + baseDatos
                                + "?autoReconnect=true&useSSL=false&connectTimeout=5000",
                        usuarioBD,
                        credencialBD)) {
                    String query = "SELECT COUNT(*) FROM resumenDocumentosProveedores WHERE access_key = ?";
                    PreparedStatement statement = conn.prepareStatement(query);
                    statement.setString(1, accessKey);

                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        if (count > 0) {
                            registroExistente = true;
                            log.info("El registro con access_key {} ya existe en la base de datos.", accessKey);
                        }
                    }
                } catch (SQLException e) {
                    log.error("Error al leer la base de datos. {}", e.toString());
                }

                // Insertar el registro si no existe
                if (!registroExistente) {
                    try (java.sql.Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://50.31.188.7/" + baseDatos
                                    + "?autoReconnect=true&useSSL=false&connectTimeout=5000",
                            usuarioBD,
                            credencialBD)) {
                        String query = "INSERT INTO resumenDocumentosProveedores (access_key, document_id, ruc_issuer, commercial_name, social_name_issuer, issued_at, establishment, point_issue, sequence, document_type, document_type_id, issued_at_formatted, total_value_without_taxes, tip, total_discount, total_amount, taxpayer_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = conn.prepareStatement(query);
                        statement.setString(1, accessKey);
                        statement.setInt(2, documentId);
                        statement.setString(3, rucIssuer);
                        statement.setString(4, commercialName);
                        statement.setString(5, socialNameIssuer);
                        statement.setString(6, issuedAt);
                        statement.setString(7, establishment);
                        statement.setString(8, pointIssue);
                        statement.setString(9, sequence);
                        statement.setString(10, documentType);
                        statement.setInt(11, documentTypeId);
                        statement.setString(12, issuedAtFormatted);
                        statement.setDouble(13, totalValueWithoutTaxes);
                        statement.setDouble(14, tip);
                        statement.setDouble(15, totalDiscount);
                        statement.setDouble(16, totalAmount);
                        statement.setString(17, taxpayerId);

                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            log.info("Inserción exitosa.");
                        } else {
                            log.info("No se pudo insertar el registro.");
                        }
                    } catch (SQLException e) {
                        log.error("Se generó una excepción al insertar el registro: {}", e.toString());
                    }
                }
            }
        } catch (Exception e) {
            log.error("Se generó una excepción al analizar la solicitud: {}", e.toString());
        }
    }

}
