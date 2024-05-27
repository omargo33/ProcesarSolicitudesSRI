package com.leon.batch.utilitarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase para manejo de archivos
 * 
 * @author omargo33
 * @since 2024-05-12
 */
@Slf4j
public class Archivos {

    /**
     * Constructor privado
     * 
     */
    private Archivos() {
        super();
    }

    /**
     * Metodo para obtener el texto de un archivo
     * 
     * @param ruta
     * @return
     */
    public static String getTexto(String ruta) {
        try {
            File file = new File(ruta);
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            log.warn("Error al leer archivo: {}", e.toString());
            return null;
        }
    }

    /**
     * Metodo para guardar un archivo en una ubicacion especifica y la crea si no
     * existe
     *
     * @param ruta
     * @param contenidoArchivo
     */
    public static void guardarArchivo(String ruta, String contenidoArchivo) {
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            fos.write(contenidoArchivo.getBytes());
            fos.close();
        } catch (IOException e) {
            log.warn("Error al guardar archivo: {}", e.toString());
        }
    }

    /**
     * Metodo para crear una ruta de archivo
     * 
     * @param clave
     * @param rutaBase
     * @return
     */
    public static String crearRutaClaveAccesoRUC(String clave, String rucCliente, String rutaBase) {
        try {
            String ruc = clave.substring(10, 23);
            String dia = clave.substring(0, 2);
            String mes = clave.substring(2, 4);
            String anio = clave.substring(4, 8);
            String tipo = clave.substring(8, 10);
            String numeroComprobante = clave.substring(23, 46);
            String separador = System.getProperty("file.separator");
            String ruta = rutaBase + separador + "documentos" + separador +
                    rucCliente + separador + ruc + separador +
                    tipo + separador + anio + "-" + mes + "-" + dia;

            File directorio = new File(ruta);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            return ruta + separador + numeroComprobante + ".xml";
        } catch (Exception e) {
            log.warn("Error al crear ruta: {}", e.toString());
            return null;
        }
    }
}