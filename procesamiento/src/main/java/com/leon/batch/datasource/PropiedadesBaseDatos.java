package com.leon.batch.datasource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase para recupear las credenciales de las bases de datos.
 * 
 * Lee las base de datos y crea una lista con todos los datos de las bases de
 * datos.
 * 
 * El archivo que se lee es databases.properties
 * 
 * 
 * @author omargo33
 * @since 2024-04-02
 *
 */
@Component
@Slf4j
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
        List<DataSourcePropiedad> listaPropiedades = new ArrayList<>();

        DataSourcePropiedad dataSourceConfig = new DataSourcePropiedad();
        dataSourceConfig.setId(environment.getProperty("datasource.datasource.id"));
        dataSourceConfig.setUrl(environment.getProperty("datasource.datasource.url"));
        dataSourceConfig.setUsername(environment.getProperty("datasource.datasource.username"));
        dataSourceConfig.setPassword(environment.getProperty("datasource.datasource.password"));
        listaPropiedades.add(dataSourceConfig);
        log.info("Data Source Base agregado {}", dataSourceConfig.toString());

        for (int i = 0; environment.containsProperty("datasource" + i + ".datasource.id"); i++) {
            String llave = "datasource" + i + ".datasource";
            DataSourcePropiedad dataSource = new DataSourcePropiedad();
            dataSource.setId(environment.getProperty(llave + ".id"));
            dataSource.setUrl(environment.getProperty(llave + ".url"));
            dataSource.setUsername(environment.getProperty(llave + ".username"));
            dataSource.setPassword(environment.getProperty(llave + ".password"));
            listaPropiedades.add(dataSource);
            log.info("Data sources {} agregado {}", llave, dataSource.toString());
        }

        return listaPropiedades;
    }
}
