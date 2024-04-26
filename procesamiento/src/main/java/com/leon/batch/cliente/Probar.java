package com.leon.batch.cliente;

import com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion;
import com.aplicaciones13.documentos.utilidades.Conversion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leon.batch.cliente.estructuras.Documento;
import com.leon.batch.cliente.estructuras.DocumentosKo;
import com.leon.batch.cliente.estructuras.DocumentosOk;
import com.leon.batch.cliente.estructuras.TokenKo;
import com.leon.batch.cliente.estructuras.TokenOk;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class Probar {
    String filePath = "/home/colaborador/ejemplo.json";

    public static void main(String[] args) {
        Probar probar = new Probar();
        probar.validarData(probar);
        probar.probarTokenOk();
    }

    private void validarData(Probar probar) {        
        String fileContent = readFile(filePath);
        DocumentosOk documentosOk = probar.getJsonRespuesta(DocumentosOk.class, fileContent);
        log.info("Cantidad de documentos: {}", documentosOk.getData().length);
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error("Error reading file: {}", e.getMessage());
        }
        return content.toString();
    }

    public <T> T getJsonRespuesta(Class<T> type, String respuesta) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return type.cast(mapper.readValue(respuesta, type));
        } catch (JsonProcessingException e) {
            log.error("super error: {}", e.toString());
            return null;
        }
    }

    private void probarTokenOk() {
        TokenConsumo tokenConsumo = new TokenConsumo();
        int estadoConsumo = tokenConsumo.load("https://auth.invoicy.app/token", "33nda5ed9snbl7edpgp7f3it1c",
                "o0js143is9nh3rc0hdgu1uu83uluic11vvrv28h88sdh3h3nubq", "client_credentials");

        switch (estadoConsumo) {
            case SolicitaServicio.SERVIDOR_ERROR:
                log.error("Error en la conexion al servidor. TokenOk {}", tokenConsumo.getRespuesta());
                break;

            case SolicitaServicio.SERVICIO_OK:
                TokenOk tokenOk = tokenConsumo.getJsonRespuesta(TokenOk.class);
                probarRide(tokenOk.getAccessToken());
                break;

            case SolicitaServicio.SERVICIO_ERROR:
                TokenKo tokenKo = tokenConsumo.getJsonRespuesta(TokenKo.class);
                if (tokenKo == null) {
                    log.error("Error TokenOk: {}", tokenConsumo.getRespuesta());
                    break;
                }

                log.error("Error Desconocido TokenOk: {}", tokenKo.getError());
                break;

            case SolicitaServicio.CORTOCIRCUITO:
                log.error("Error esta en cortocircuito. TokenOk");
                break;

            default:
                break;
        }
    }

    public void probarListaDocumentos(String token) {
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
                log.error("Error en la conexion al servidor. ListaDocumentos {}", descargarDocumentosConsumo.toString());
                break;

            case SolicitaServicio.SERVICIO_OK:
                DocumentosOk documentosOk = descargarDocumentosConsumo.getJsonRespuesta(DocumentosOk.class);

                for (Documento documento : documentosOk.getData()) {
                    log.info("Documento: ListaDocumentos {}", documento.toString());
                }
                break;

            case SolicitaServicio.SERVICIO_ERROR:
                DocumentosKo documentosKo = descargarDocumentosConsumo.getJsonRespuesta(DocumentosKo.class);
                if (documentosKo == null) {
                    log.error("Error: ListaDocumentos {}", descargarDocumentosConsumo.getRespuesta());
                    break;
                }

                log.error("Error: ListaDocumentos {}", documentosKo.getMessage());
                break;

            case SolicitaServicio.CORTOCIRCUITO:
                log.error("Error esta en cortocircuito. ListaDocumentos");
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
                log.error("Error en la conexion al servidor. {}", descargarConsumo.getRespuesta());
                break;

            case SolicitaServicio.SERVICIO_OK:
                String respuesta = descargarConsumo.getRespuesta();

                Autorizacion authorization = Conversion.xmlToPojo(descargarConsumo.getRespuesta(), Autorizacion.class);
                log.info("Documento: {}", respuesta);
                log.info("Estado: {}", authorization.getEstado());
                log.info("Fecha Autorizacion: {}", authorization.getFechaAutorizacion());
                log.info("No autorizacion: {}",authorization.getNumeroAutorizacion());
                break;

            case SolicitaServicio.SERVICIO_ERROR:
                String respuestaError = descargarConsumo.getRespuesta();
                log.error("Documento: {}", respuestaError);
                break;

            case SolicitaServicio.CORTOCIRCUITO:
                log.error("Error esta en cortocircuito.");
                break;

            default:
                break;
        }
    }

}
