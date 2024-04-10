package com.leon.batch.cliente;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Document;

import com.leon.batch.cliente.estructuras.autorizacion.Authorization;

import java.nio.charset.StandardCharsets;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase para realizar solicitudes JSON para descargar el XML.
 * 
 * @autor omargo33
 * @since 2024-04-09
 * 
 */
@Getter
@Setter
@Slf4j
public class DescargarConsumo extends SolicitaServicio {

    // Se define el tinmeout de la conexion.
    int timeOut = 30000;
    String credencial = "";
    String token = "";
    String usuario = "";

    /**
     * Metodo para cargar el token.
     * 
     * @param ulString
     * @param token
     * @param usuario
     * @param credencial
     * @param claveAcceso
     * @return
     */
    public int load(String ulString, String token, String usuario, String credencial, String claveAcceso) {
        this.token = token;
        this.usuario = usuario;
        this.credencial = credencial;

        setTimeOut(timeOut);
        setTipoConsulta(CONSULTA_URL_PARAMETROS);
        setUrlConsulta(ulString + "/" + claveAcceso);

        return ejecutarCortoCircutio(this.getClass().getName());
    }

    /**
     * Metodo para sobrecargar la conexion.
     *
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    @Override
    public HttpURLConnection generarConexion() throws IOException {
        String credencial = getUsuario() + ":" + getCredencial();
        String credencial64 = Base64.getEncoder().encodeToString(credencial.getBytes(StandardCharsets.UTF_8));
        URL url = new URL(getUrlConsulta());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        connection.setRequestProperty("Authorization", "Bearer " + getToken());
        connection.setRequestProperty("X-SRI-Credentials", credencial64);

        return connection;
    }

    /**
     * Metodo para conocer si la respuesta es valida del servicio es valida para la
     * logica por un archivo import org.w3c.dom.Document;
     *
     * @return
     */
    @Override
    public boolean isRespuestaValida() {
        Document document = getXMLRespuesta();
        return (document != null);
    }

    /**
     * Metodo para construir el objeto Authorization.
     *
     * @param xml
     * @return
     */
    public Authorization construirAuthorization(String xml) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Authorization.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Authorization authorization = (Authorization) unmarshaller
                    .unmarshal(new ByteArrayInputStream(xml.getBytes()));
            return authorization;
        } catch (JAXBException e) {
            log.error("Error al construir el objeto Authorization: " + e.getMessage());
            return null;
        }
    }
}