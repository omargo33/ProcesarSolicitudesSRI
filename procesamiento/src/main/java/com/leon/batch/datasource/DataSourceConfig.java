package com.leon.batch.datasource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.RequiredArgsConstructor;

/**
 * Clase para la configuracion de las bases de datos.
 * 
 * Se encarga de configurar las bases de datos a las que se conecta la aplicacion.
 * 
 * @author omargo33
 * @since 2024-04-02
 * 
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.leon.estructura.persistencia.crud", transactionManagerRef = "transcationManager", entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
@RequiredArgsConstructor
public class DataSourceConfig {

    private final PropiedadesBaseDatos baseDatos;

    @Bean
    @Primary
    public DataSource dataSource() {
        DataSourceRouting routingDataSource = new DataSourceRouting();
        routingDataSource.initDatasource(getDataSourceCeroDataSource());
        return routingDataSource;
    }

    private Map<Object, Object> getDataSourceCeroDataSource() {

        Map<Object, Object> listaDataSources = new HashMap<>();
        List<DataSourcePropiedad> listaPropiedades = baseDatos.getAllProperties();

        for (DataSourcePropiedad dataSourcePropiedad : listaPropiedades) {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl(dataSourcePropiedad.getUrl());
            dataSource.setUsername(dataSourcePropiedad.getUsername());
            dataSource.setPassword(dataSourcePropiedad.getPassword());
            listaDataSources.put(dataSourcePropiedad.getId(), dataSource);
        }

        return listaDataSources;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource()).packages("com.leon.estructura.persistencia.entidad").build();
    }

    @SuppressWarnings("null")
    @Bean(name = "transcationManager")
    public JpaTransactionManager transactionManager(
            @Autowired @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
