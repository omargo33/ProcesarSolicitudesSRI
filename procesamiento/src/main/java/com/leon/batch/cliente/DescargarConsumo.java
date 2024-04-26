package com.leon.batch.cliente;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import org.w3c.dom.Document;


import java.nio.charset.StandardCharsets;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase para realizar solicitudes JSON para descargar el XML.
 * 
 * @autor omargo33
 * @since 2024-04-09
 * 
 */
@Getter
@Setter
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
        String usuarioCredencial = getUsuario() + ":" + getCredencial();
        String credencial64 = Base64.getEncoder().encodeToString(usuarioCredencial.getBytes(StandardCharsets.UTF_8));
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
}