package com.leon.batch.utilitarios;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase para
 * 
 * 
 */
@Slf4j
public class Comprobante {

    public static final String FACTURA = "01";
    public static final String LIQUIDACION_COMPRA = "03";
    public static final String NOTA_CREDITO = "04";
    public static final String NOTA_DEBITO = "05";
    public static final String GUIA_REMISION = "06";
    public static final String COMPROBANTE_RETENCION = "07";

    /**
     * Metodo para conocer el tipo de documento.
     * 
     * @param claveAcceso
     * @return
     */
    public static String conocerDocumento(String claveAcceso) {
        if (claveAcceso == null || claveAcceso.length() < 49) {
            return null;
        }
        return claveAcceso.substring(8, 10);
    }

    /**
     * Metodo para obtener el documento parseado sobre los objetos de la estructura.
     * 
     * @param <T>
     * @param documentoXml
     * @param type
     * @return
     */
    public <T> T obtenerDocumentoParseado(String documentoXml, Class<T> type) {
        try {
            JAXBContext jc = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return type.cast(unmarshaller.unmarshal(new ByteArrayInputStream(documentoXml.getBytes())));
        } catch (JAXBException e) {
            log.warn("Error al construir el objeto XML: {}", e.toString());
            return null;
        }
    }

    /**
     * Metodo para crear el path del archivo.
     * 
     * @param ruc
     * @param producto
     * @param fecha
     * @return
     */
    public static String crearPathFile(String ruc, String producto, String fecha) {
        String fileSeparador = System.getProperty("file.separator");
        String fullPath = System.getProperty("user.home") + 
            fileSeparador + ruc + 
            fileSeparador + producto + 
            fileSeparador + fecha;

        try {
            Path path = Paths.get(fullPath);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            log.warn("No se pudo crear: {} por {}", fullPath, e.toString());
        }

        return fullPath;
    }

    /**
     * Metodo para guardar el archivo.
     * 
     * @param path
     * @param nombre
     * @param contenido
     */
    public static void guardarArchivo(String path, String nombre, String contenido) {
        try {
            Path pathFile = Paths.get(path + System.getProperty("file.separator") + nombre);
            Files.write(pathFile, contenido.getBytes());
        } catch (IOException e) {
            log.warn("No se pudo guardar el archivo: {} por {}", nombre, e.toString());
        }
    }
}
