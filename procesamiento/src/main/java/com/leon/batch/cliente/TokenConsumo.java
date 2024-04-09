package com.leon.batch.cliente;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.leon.batch.cliente.estructuras.TokenOk;

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
public class TokenConsumo extends SolicitaServicio {

    
    // Se define el tinmeout de la conexion en 10 segundos.
    int timeOut = 10000;

    /**
     * Metodo para cargar el token.
     * 
     * @param ulString
     * @param clientId
     * @param clientSecret
     * @param grantType
     * @return
     */
    public int load(String ulString, String clientId, String clientSecret, String grantType) {
        String urlParameters = "";

        try {
            urlParameters = String.format("client_id=%s&client_secret=%s&grant_type=%s",
                    URLEncoder.encode(clientId, "UTF-8"),
                    URLEncoder.encode(clientSecret, "UTF-8"),
                    URLEncoder.encode(grantType, "UTF-8"));
        } catch (Exception e) {
            return SERVIDOR_ERROR;
        }

        setTimeOut(timeOut);
        setUrlConsulta(ulString);
        setTipoConsulta(CONSULTA_FORM_PARAMETROS);
        setParametrosConsulta(urlParameters);

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
        URL url = new URL(getUrlConsulta());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Accept", "application/json");
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