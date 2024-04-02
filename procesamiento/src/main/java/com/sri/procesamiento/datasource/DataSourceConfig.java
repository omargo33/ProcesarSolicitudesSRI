package com.sri.procesamiento.datasource;

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

@Configuration
@EnableJpaRepositories(basePackages = "com.leon.estructura.persistencia.crud", transactionManagerRef = "transcationManager", entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
@RequiredArgsConstructor
public class DataSourceConfig {

    private final DataSourceCeroConfig dataSourceCeroConfig;
    private final DataSourceOneConfig dataSourceOneConfig;
    private final DataSourceTwoConfig dataSourceTwoConfig;

    @Bean
    @Primary
    public DataSource dataSource() {
        DataSourceRouting routingDataSource = new DataSourceRouting();
        routingDataSource.initDatasource(dataSourceCeroDataSource(), dataSourceOneDataSource(),
                dataSourceTwoDataSource());
        return routingDataSource;
    }

    public DataSource dataSourceCeroDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceCeroConfig.getUrl());
        dataSource.setUsername(dataSourceCeroConfig.getUsername());
        dataSource.setPassword(dataSourceCeroConfig.getPassword());
        return dataSource;
    }

    public DataSource dataSourceOneDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceOneConfig.getUrl());
        dataSource.setUsername(dataSourceOneConfig.getUsername());
        dataSource.setPassword(dataSourceOneConfig.getPassword());
        return dataSource;
    }

    public DataSource dataSourceTwoDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceTwoConfig.getUrl());
        dataSource.setUsername(dataSourceTwoConfig.getUsername());
        dataSource.setPassword(dataSourceTwoConfig.getPassword());
        return dataSource;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource()).packages("com.leon.estructura.persistencia.entidad").build();
    }

    @Bean(name = "transcationManager")
    public JpaTransactionManager transactionManager(
            @Autowired @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
