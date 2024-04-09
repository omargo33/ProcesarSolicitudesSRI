package com.leon.batch.cliente;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leon.batch.cliente.estructuras.Documento;
import com.leon.batch.cliente.estructuras.DocumentosKo;
import com.leon.batch.cliente.estructuras.DocumentosOk;
import com.leon.batch.cliente.estructuras.TokenKo;
import com.leon.batch.cliente.estructuras.TokenOk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Probar {

    public static void main001(String[] args) {
        Probar probar = new Probar();
        // probar.validarData(probar);
        probar.probarTokenOk();
    }

    private void validarData(Probar probar) {
        String filePath = "/home/colaborador/ejemplo.json";
        String fileContent = readFile(filePath);
        DocumentosOk documentosOk = probar.getJsonRespuesta(DocumentosOk.class, fileContent);
        // System.out.println("Documentos: " + documentosOk.toString());
        System.out.println("Cantidad de documentos: " + documentosOk.getData().length);
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }

    public <T> T getJsonRespuesta(Class<T> type, String respuesta) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            T entity = mapper.readValue(respuesta, type);
            return entity;
        } catch (JsonProcessingException e) {
            System.out.println("super error: " + e.toString());
            return null;
        }
    }

    private void probarTokenOk() {
        TokenConsumo tokenConsumo = new TokenConsumo();
        int estadoConsumo = tokenConsumo.load("https://auth.invoicy.app/token", "33nda5ed9snbl7edpgp7f3it1c",
                "o0js143is9nh3rc0hdgu1uu83uluic11vvrv28h88sdh3h3nubq", "client_credentials");

        switch (estadoConsumo) {
            case SolicitaServicio.SERVIDOR_ERROR:
                System.err.println("Error en la conexion al servidor." + tokenConsumo.getRespuesta());
                break;

            case SolicitaServicio.SERVICIO_OK:
                TokenOk tokenOk = tokenConsumo.getJsonRespuesta(TokenOk.class);
                probarRide(tokenOk.getAccessToken());
                break;

            case SolicitaServicio.SERVICIO_ERROR:
                TokenKo tokenKo = tokenConsumo.getJsonRespuesta(TokenKo.class);
                if (tokenKo == null) {
                    System.err.println("Error: " + tokenConsumo.getRespuesta());
                    break;
                }

                System.err.println("Error: " + tokenKo.getError());
                break;

            case SolicitaServicio.CORTOCIRCUITO:
                System.err.println("Error esta en cortocircuito.");
                break;

            default:
                break;
        }
    }

    private void probarListaDocumentos(String token) {
        DocumentosRecibidosConsumo descargarDocumentosConsumo = new DocumentosRecibidosConsumo();
        int estadoConsumo = descargarDocumentosConsumo.load(
                // "https://api.invoicy.app/v1/documents/sales",
                "https://api.invoicy.app/v1/documents",
                token,
                "1715726772001",
                "Indupan1111@",
                "12",
                "2023");
        switch (estadoConsumo) {
            case SolicitaServicio.SERVIDOR_ERROR:
                System.err.println("Error en la conexion al servidor." + descargarDocumentosConsumo.toString());
                break;

            case SolicitaServicio.SERVICIO_OK:
                DocumentosOk documentosOk = descargarDocumentosConsumo.getJsonRespuesta(DocumentosOk.class);

                for (Documento documento : documentosOk.getData()) {
                    System.out.println("Documento: " + documento.toString());
                }
                break;

            case SolicitaServicio.SERVICIO_ERROR:
                DocumentosKo documentosKo = descargarDocumentosConsumo.getJsonRespuesta(DocumentosKo.class);
                if (documentosKo == null) {
                    System.err.println("Error: " + descargarDocumentosConsumo.getRespuesta());
                    break;
                }

                System.err.println("Error: " + documentosKo.getMessage());
                break;

            case SolicitaServicio.CORTOCIRCUITO:
                System.err.println("Error esta en cortocircuito.");
                break;

            default:
                break;
        }
    }

    private void probarRide(String token) {
        DescargarConsumo descargarConsumo = new DescargarConsumo();
        int estadoConsumo = descargarConsumo.load(
                // "https://api.invoicy.app/v1/documents/sales",
                "https://api.invoicy.app/v1/documents",
                token,
                "1715726772001",
                "Indupan1111@",
                "0412202301019048909400120010060000108370103321411");
        switch (estadoConsumo) {
            case SolicitaServicio.SERVIDOR_ERROR:
                System.err.println("Error en la conexion al servidor." + descargarConsumo.toString());
                break;

            case SolicitaServicio.SERVICIO_OK:
                String respuesta = descargarConsumo.getRespuesta();
                System.out.println("Documento: " + respuesta);
                break;

            case SolicitaServicio.SERVICIO_ERROR:
                String respuestaError = descargarConsumo.getRespuesta();
                System.out.println("Documento: " + respuestaError);
                break;

            case SolicitaServicio.CORTOCIRCUITO:
                System.err.println("Error esta en cortocircuito.");
                break;

            default:
                break;
        }
    }

}
