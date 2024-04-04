package com.leon.batch.cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase para realizar solicitudes REST a un web services.
 * 
 * @autor omargo33
 * @since 2023-11-09
 * 
 */
@Getter
@Setter
@Slf4j
public class SolicitaREST {

    public static final String CONSULTA_JSON = "JSON";
    public static final String CONSULTA_PARAMETROS = "URL_PARAMETROS";
    
    public static final int SERVICIO_OK = 1;
    public static final int SERVICIO_ERROR = 0;
    public static final int SERVIDOR_ERROR = -1;
    public static final int CORTOCIRCUITO = -2;
    
    private int timeOut;
    private int httpEstado = 0;
    private String jsonConsulta;
    private String parametrosConsulta;
    private String urlConsulta;
    private String respuesta;
    private String errorRespuesta;
    private String tipoConsulta;
    private final Date fechaInicio;
    private Date fechaFin;

    /**
     * Metodo para crear el objeto.
     *
     */
    public SolicitaREST() {
        super();
        timeOut = 0;
        httpEstado = 0;
        jsonConsulta = "";
        parametrosConsulta = "";
        urlConsulta = "";
        respuesta = "";
        fechaInicio = new Date();
        fechaFin = new Date();
    }

    /**
     * Metodo para ejecutar una solicitud SOAP a un web services.
     *
     * Proceso el ingreso a sitios SSL. Inicializa mensajes de error Inicializa
     * datos para la conexion. Prepara a la conexion para enviar, recibir datos
     * y tiempos de espera en conexion y de escritura. Abre el puerto output y
     * envia el xml a ser consultado y cierra el puerto. Pregunta el estado de
     * la respuesta. Si la respuesta es HTTP_OK estado html 200 "respuesta ok
     * del servidor consultado" Lee el contendio del imputStream Caso contrario
     * Lee el contenido del imputStream de Error
     *
     * Consume el contenido del imputStream y pasa a un respuestaSOAP Cierra la
     * conexion al servidor.
     *
     * Si existio un error en el servidor lo notifica Devuelve el valor de la
     * consulta al web service.
     *
     * @throws Exception
     *
     */
    private void ejecutarConsultaRESTService() throws Exception {
        String responseString = "";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = null;

        HttpURLConnection connection = generarConexion();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setConnectTimeout(getTimeOut());
        connection.setReadTimeout(getTimeOut());

        switch (tipoConsulta) {
            case CONSULTA_JSON:
                // Ejecuta si la consulta tiene una solicitud JSON
                if (jsonConsulta != null && jsonConsulta.length() > 0) {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                    outputStreamWriter.write(jsonConsulta);
                    outputStreamWriter.close();
                }
                break;
            case CONSULTA_PARAMETROS:
                // Ejecuta si la consulta tiene una solicitud Param URL
                if (parametrosConsulta != null && parametrosConsulta.length() > 0) {
                    DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
                    outputStream.writeBytes(parametrosConsulta);
                    outputStream.flush();
                    outputStream.close();
                }
                break;

            default:
                log.warn("Tipo de consulta no definido");
                break;
        }

        httpEstado = connection.getResponseCode();

        if (getHttpEstado() != HttpURLConnection.HTTP_OK) {
            inputStream = connection.getErrorStream();
        } else {
            inputStream = connection.getInputStream();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while ((responseString = bufferedReader.readLine()) != null) {
            stringBuilder.append(responseString);
        }

        bufferedReader.close();
        fechaFin = new Date();

        if (getHttpEstado() != HttpURLConnection.HTTP_OK) {
            errorRespuesta = stringBuilder.toString();
            throw new Exception(String.valueOf(getHttpEstado()));
        }

        respuesta = stringBuilder.toString();
    }

    /**
     * Metodo para crear una nueva conexion.
     *
     * Se la puede sobrecargar.
     *
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public HttpURLConnection generarConexion() throws IOException {
        URL url = new URL(this.urlConsulta);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection;
    }

    /**
     * @return
     */
    public int getTimeOut() {
        return (timeOut == 0) ? 15000 : timeOut;
    }

    /*
     * Metodo para convertir una salida JSON a un objeto.
     * 
     * @param type
     * 
     * @return
     */
    public <T> T getJsonRespuesta(Class<T> type) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            T entity = mapper.readValue(respuesta, type);
            return entity;
        } catch (JsonProcessingException e) {
            log.error("Error al convertir la respuesta JSON", e);
            return null;
        }
    }


    /**
     * Metodo para ejecutar la consulta.
     * 
     * Este suele tener un flujo personalizado para cada servicio.
     * 
     * Ejecuta la consulta y devuelve el resultado que es validado por el metodo
     * 
     * Y luego con la respueta de error del servidor se procesa y se personaliza las acciones.
     * 
     * @return
     */
    public int ejecutar() {
        try {
            ejecutarConsultaRESTService();
        } catch (Exception e) {
            return SERVIDOR_ERROR;
        }
        if (getHttpEstado() == 200) {
            if (isRespuestaValida()) {
                return SERVICIO_OK;
            }
            return SERVICIO_ERROR;
        }
        
        return SERVIDOR_ERROR;
    }

    /**
     * Metodo para conocer
     *
     * @param json
     * @return
     */
    public boolean isRespuestaValida() {
        log.warn("no se ha personalizado la consulta");                   
        return false;
    }

    /**
	 * Metodo para implementar circuit breaker.
	 * 
	 * @param ingresoOk
	 * @param email
	 * @param urlString
	 * @param atributos
	 * @return
	 */
	public int ejecutarCortoCircutio(String nombreCortoCircuito) {
        int estadoEjecucion = SERVICIO_OK;
		String circuitBreaker = System.getProperty(nombreCortoCircuito);

		if (circuitBreaker == null || circuitBreaker.isEmpty()) {
			estadoEjecucion = ejecutar();
		} else {
			try {
				long time = Long.parseLong(circuitBreaker);
				time = time + 60000;
				if (time < new Date().getTime()) {
					estadoEjecucion = ejecutar();
				}else {
                    estadoEjecucion = CORTOCIRCUITO;
                }
			} catch (NumberFormatException e) {
				log.error(".cortoCircutio() {}", circuitBreaker);
                estadoEjecucion = SERVIDOR_ERROR;
			}
		}

        if (estadoEjecucion == SERVIDOR_ERROR) {
            System.setProperty(nombreCortoCircuito, String.valueOf(new Date().getTime()));            
        }

		return estadoEjecucion;
	}
}