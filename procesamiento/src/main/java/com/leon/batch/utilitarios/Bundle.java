package com.leon.batch.utilitarios;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;


/**
 * Clase que permite cargar un archivo de propiedades y obtener los mensajes
 * 
 * @author omargo33
 * @since 2024-04-03
 *
 */
@Slf4j
public class Bundle {
    private static final String DEFAULT_LANGUAGE = "es";
    private static final String DEFAULT_FILE = "/resources/menssages.properties";

    private Properties properties;

    public Bundle() {
        this(DEFAULT_LANGUAGE);
    }

    public Bundle(String language) {
        loadProperties(language);
    }

    public String getMessage(String key, Object... params) {
        String message = properties.getProperty(key);
        if (message == null) {
            return "";
        }
        return String.format(message, params);
    }

    private void loadProperties(String language) {
        properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream(DEFAULT_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            log.error("Error al cargar el archivo de propiedades {}", e);
        }
    }
}