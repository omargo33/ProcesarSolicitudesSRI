package com.leon.batch.datasource;

import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Clase para el enrutamiento de las bases de datos.
 * 
 * Se encarga de enrutar las bases de datos a las que se conecta la aplicacion.
 * 
 * @author omargo33
 * @since 2024-04-02
 * 
 */
public class DataSourceRouting extends AbstractRoutingDataSource {
		
	/**
	 * Metodo para determinar la base de datos a la que se conecta.
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getBranchContext();
	}

	/**
	 * Metodo para inicializar las bases de datos.
	 * 
	 * @param mapDataSources
	 */	
	@SuppressWarnings("null")
	public void initDatasource(Map<Object, Object> mapDataSources) {
		this.setTargetDataSources(mapDataSources);
		this.setDefaultTargetDataSource(mapDataSources.get("config"));
	}
}
