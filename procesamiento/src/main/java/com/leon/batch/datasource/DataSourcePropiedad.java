package com.leon.batch.datasource;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Estructura para las propiedades de las bases de datos.
 *
 * @author omargo33
 * @since 2024-04-02
 */
@Component
@Data
public class DataSourcePropiedad {
    private String id;
	private String url;
	private String password;
	private String username;
}
