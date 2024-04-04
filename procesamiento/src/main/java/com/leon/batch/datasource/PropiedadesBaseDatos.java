package com.leon.batch.datasource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


/**
 * Clase para recupear las credenciales de las bases de datos.
 * 
 * Lee las base de datos y crea una lista con todos los datos de las bases de datos.
 * 
 * El archivo que se lee es databases.properties
 * 
 * 
 * @author omargo33
 * @since 2024-04-02
 *
 */
@Component
@PropertySource("classpath:databases.properties")
public class PropiedadesBaseDatos {

    @Autowired
    private Environment environment;

    /**
     * Metodo para recuperar las propiedades de las bases de datos.
     * 
     * @return lista de propiedades de las bases de datos.
     */
    public List<DataSourcePropiedad> getAllProperties() {
        //TODO falta condificar el perfil de spring: dev, test, prod
        int i=0;
        List<DataSourcePropiedad> listaPropiedades = new ArrayList<>();

        DataSourcePropiedad dataSourceConfig = new DataSourcePropiedad();
        dataSourceConfig.setId(environment.getProperty("datasourceConfig.datasource.id"));
        dataSourceConfig.setUrl(environment.getProperty("datasourceConfig.datasource.url"));
        dataSourceConfig.setUsername(environment.getProperty("datasourceConfig.datasource.username"));
        dataSourceConfig.setPassword(environment.getProperty("datasourceConfig.datasource.password"));
        listaPropiedades.add(dataSourceConfig);
        
        while (environment.containsProperty("datasource"+i+".datasource.id")) {
            DataSourcePropiedad dataSource = new DataSourcePropiedad();
            dataSource.setId(environment.getProperty("datasource"+i+".datasource.id"));
            dataSource.setUrl(environment.getProperty("datasource"+i+".datasource.url"));
            dataSource.setUsername(environment.getProperty("datasource"+i+".datasource.username"));
            dataSource.setPassword(environment.getProperty("datasource"+i+".datasource.password"));
            listaPropiedades.add(dataSource);
            i++;        
        }

        return listaPropiedades;
    }
}
