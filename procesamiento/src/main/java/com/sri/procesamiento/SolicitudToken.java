
package com.sri.procesamiento;

import static com.sri.procesamiento.Configuracion.URL_GENERAR_TOKEN;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

public class SolicitudToken {

    String token;
    
    public void procesarSolicitud(String clientId,String clientSecret,String grantType){
        
        try {
   
            String url = URL_GENERAR_TOKEN;
            URL apiUrl = new URL(url);
 
             String urlParameters = "client_id=" + URLEncoder.encode(clientId, "UTF-8") +
                    "&client_secret=" + URLEncoder.encode(clientSecret, "UTF-8") +
                    "&grant_type=" + URLEncoder.encode(grantType, "UTF-8");

            // Abrir conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");


            // Habilitar el envío de datos
            connection.setDoOutput(true);

            // Escribir el payload en el flujo de salida de la conexión
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(urlParameters);
            outputStream.flush();
            outputStream.close();

            // Obtener el código de respuesta
            int responseCode = connection.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode);

            // Leer la respuesta del servicio
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Imprimir la respuesta
            System.out.println("Respuesta del servicio:");
            System.out.println(response.toString());
              
            try {
                // Analizar la respuesta JSON
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Obtener los valores del JSON
                String accessToken = jsonResponse.getString("access_token");
                int expiresIn = jsonResponse.getInt("expires_in");
                String tokenType = jsonResponse.getString("token_type");

                // Imprimir los valores obtenidos
                System.out.println("Access Token: " + accessToken);
                System.out.println("Expires In: " + expiresIn);
                System.out.println("Token Type: " + tokenType);

                setToken(accessToken);
                
            } catch (Exception e) {
                System.out.println("No se puedo analizar la respuesta: " + e.toString());
            }

            // Cerrar la conexión
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    
    
}