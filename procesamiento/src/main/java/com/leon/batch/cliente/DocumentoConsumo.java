package com.leon.batch.cliente;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.leon.batch.cliente.estructuras.TokenOk;
import java.util.Base64;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase para realizar solicitudes REST al token.
 * 
 * @autor omargo33
 * @since 2024-04-04
 * 
 */
@Getter
@Setter
public class DocumentoConsumo extends SolicitaREST {

    // Se define el tinmeout de la conexion en 10 segundos.
    int timeOut = 10000;
    String token = "";
    String usuario = "";
    String credencial = "";

    /**
     * Metodo para cargar el token.
     * 
     * @param ulString
     * @param clientId
     * @param clientSecret
     * @param grantType
     * @return
     */
    public int load(String ulString, String token, String usuario, String credencial, String claveAcceso) {
        this.token = token;
        this.usuario = usuario;
        this.credencial = credencial;

        setTimeOut(timeOut);
        setUrlConsulta(ulString + "/" + claveAcceso);
        setTipoConsulta(CONSULTA_JSON);

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
        URL url = new URL(getUrlConsulta());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + getToken());
        connection.setRequestProperty("X-SRI-Credentials",
                Base64.getEncoder().encodeToString(credencial.getBytes(StandardCharsets.UTF_8)));

        return connection;
    }

    /**
     * Metodo para conocer si la respuesta es valida del servicio es valida para la
     * logica.
     *
     * @param json
     * @return
     */
    @Override
    public boolean isRespuestaValida() {
        TokenOk tokenOk = getJsonRespuesta(TokenOk.class);
        if (tokenOk != null && tokenOk.getAccessToken() != null && !tokenOk.getAccessToken().isEmpty()) {
            return true;
        }
        return false;
    }
}