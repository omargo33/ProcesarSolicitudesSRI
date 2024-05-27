package com.leon.batch.cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@ToString
@Slf4j
public class SolicitaServicio{
    public static final String CONSULTA_FORM_PARAMETROS = "FORM_PARAMETROS";
    public static final String CONSULTA_JSON = "JSON";
    public static final String CONSULTA_SOAP = "SOAP";
    public static final String CONSULTA_URL_PARAMETROS = "URL_PARAMETROS";

    public static final int CORTOCIRCUITO = -2;
    public static final int SERVICIO_ERROR = 0;
    public static final int SERVICIO_OK = 1;
    public static final int SERVIDOR_ERROR = -1;

    private int httpEstado = 0;
    private int timeOut;
    private String jsonConsulta;
    private String parametrosConsulta;
    private String xmlConsulta;
    private String respuesta;
    private String tipoConsulta;
    private String urlConsulta;
    private final Date fechaInicio;
    private Date fechaFin;

    /**
     * Metodo para crear el objeto.
     *
     */
    public SolicitaServicio() {
        super();
        httpEstado = 0;
        timeOut = 0;
        jsonConsulta = "";
        parametrosConsulta = "";
        xmlConsulta = "";
        respuesta = "";
        urlConsulta = "";
        fechaFin = new Date();
        fechaInicio = new Date();
    }

    /**
     * Metodo para ejecutar una solicitud SOAP a un web services.
     *
     * Proceso el ingreso a sitios SSL. Inicializa mensajes de error Inicializa
     * datos para la conexion. Prepara a la conexion para enviar, recibir datos
     * y tiempos de espera en conexion y de escritura. Abre el puerto output y
     * envia el xml a ser consultado y cierra el puerto. Pregunta el estado de
     * la respuesta. Si la respuesta es 20X "respuesta ok
     * del servidor consultado" Lee el contendio del imputStream Caso contrario
     * Lee el contenido del imputStream de Error
     *
     * Consume el contenido del imputStream y pasa a un respuestaSOAP/JSON Cierra la
     * conexion al servidor.
     *
     * Si existio un error en el servidor lo notifica Devuelve el valor de la
     * consulta al web service.
     *
     * @throws Exception
     *
     */
    private void ejecutarConsultaService() throws Exception {
        String responseString = "";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = null;

        HttpURLConnection connection = generarConexion();
        connection.setDoOutput(true);
        connection.setDoInput(true);

        if (getTimeOut() > 0) {
            connection.setConnectTimeout(getTimeOut());
            connection.setReadTimeout(getTimeOut());
        }

        if (!rutearSolicitud(connection)) {
            log.error("Error Tipo de consulta no definido");
        }

        httpEstado = connection.getResponseCode();
        if (isHttpstatusValido(getHttpEstado()) == SERVICIO_OK) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((responseString = bufferedReader.readLine()) != null) {
            stringBuilder.append(responseString);
        }

        bufferedReader.close();
        fechaFin = new Date();

        if (isHttpstatusValido(getHttpEstado()) == SERVICIO_ERROR) {
            respuesta = stringBuilder.toString();
        }
        if (isHttpstatusValido(getHttpEstado()) == SERVIDOR_ERROR) {
            throw new Exception(String.valueOf(getHttpEstado()));
        }

        respuesta = stringBuilder.toString();
    }

    /**
     * Metodo para hacer el enrutamiento de la solicitud.
     * 
     * Si es una solicitud SOAP(XML), JSON({atributo:"valor"}),
     * FORM_PARAMETROS(semejante a form de html) o
     * URL_PARAMETROS(?key1=valor1&key20valor2).
     * 
     * Este ultimo es directo a la URL y por eso no se envia nada.
     * 
     * @param connection
     * @return
     * @throws IOException
     */
    private boolean rutearSolicitud(HttpURLConnection connection) throws IOException {
        switch (tipoConsulta) {
            case CONSULTA_SOAP:
                if (xmlConsulta != null && xmlConsulta.length() > 0) {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                    outputStreamWriter.write(xmlConsulta);
                    outputStreamWriter.close();
                }else{
                    log.error("No se ha definido el xml de la consulta");
                }
                break;
            case CONSULTA_JSON:
                if (jsonConsulta != null && jsonConsulta.length() > 0) {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                    outputStreamWriter.write(jsonConsulta);
                    outputStreamWriter.close();
                }else{
                    log.error("No se ha definido el json de la consulta");
                }
                break;
            case CONSULTA_FORM_PARAMETROS:
                if (parametrosConsulta != null && parametrosConsulta.length() > 0) {
                    DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
                    outputStream.writeBytes(parametrosConsulta);
                    outputStream.flush();
                    outputStream.close();
                } else{
                    log.error("No se ha definido los parametros de formulario de la consulta");
                }
                break;
            case CONSULTA_URL_PARAMETROS:
                break;
                
            default:
                log.error("No se ha definido el tipo de consulta {}", tipoConsulta);
                return false;
        }

        return true;
    }

    /**
     * Metodo para analizar el estado de la respues.
     *
     * @return
     */
    public int isHttpstatusValido(int httpStatus) {
        if (httpStatus >= HttpURLConnection.HTTP_OK && httpStatus < HttpURLConnection.HTTP_MULT_CHOICE) {
            return SERVICIO_OK;
        }

        if (httpStatus >= HttpURLConnection.HTTP_MULT_CHOICE && httpStatus < HttpURLConnection.HTTP_UNSUPPORTED_TYPE) {
            return SERVICIO_ERROR;
        }

        log.error("Error en la conexion al servidor. Estado: {}", httpStatus);
        return SERVIDOR_ERROR;
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
        return (HttpURLConnection) url.openConnection();
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
            return type.cast(mapper.readValue(respuesta, type));
        } catch (JsonProcessingException e) {
            log.warn("Conversion por getJsonRespuesta() {}", e.toString());
            return null;
        }
    }

    /**
     * Metodo para convertir una salida XML a un objeto.
     * 
     * @return
     */
    public Document getXMLRespuesta() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            factory.setNamespaceAware(true);
            builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(respuesta)));            
        } catch (Exception e) {
            log.warn("Conversion por getJsonRespuesta() {}", e.toString());
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
     * Y luego con la respueta de error del servidor se procesa y se personaliza las
     * acciones.
     * 
     * @return
     */
    public int ejecutar() {
        try {
            ejecutarConsultaService();
            return isHttpstatusValido(getHttpEstado());
        } catch (Exception e) {
            log.warn("Error al ejecutar la consulta. {}", e.toString());
            return SERVIDOR_ERROR;
        }
    }

    /**
     * Metodo para conocer
     *
     * @param json
     * @return
     */
    public boolean isRespuestaValida() {
        log.info("No se ha personalizado la consulta");
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
        int estadoEjecucion = 1;
        String circuitBreaker = System.getProperty("CortoCircuito=" + nombreCortoCircuito);

        if (circuitBreaker == null || circuitBreaker.isEmpty()) {
            estadoEjecucion = ejecutar();
        } else {
            try {
                long time = Long.parseLong(circuitBreaker);
                time = time + 60000;
                if (time < new Date().getTime()) {
                    estadoEjecucion = ejecutar();
                } else {
                    estadoEjecucion = CORTOCIRCUITO;
                    log.error("CortoCircuito ACTIVO: {}", nombreCortoCircuito);
                }
            } catch (NumberFormatException e) {
                log.warn(".cortoCircutio() {}", circuitBreaker);
                estadoEjecucion = SERVIDOR_ERROR;
            }
        }

        if (estadoEjecucion == SERVIDOR_ERROR) {
            log.error("CortoCircuito CREADO: {}", nombreCortoCircuito);
            System.setProperty("CortoCircuito=" + nombreCortoCircuito, String.valueOf(new Date().getTime()));
        }

        return estadoEjecucion;
    }
}