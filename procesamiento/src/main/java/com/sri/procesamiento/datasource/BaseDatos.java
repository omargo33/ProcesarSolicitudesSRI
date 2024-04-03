package com.sri.procesamiento.datasource;

import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@PropertySource("classpath:databases.properties")
@Slf4j
public class BaseDatos {


    @Autowired
private Environment env;

    public Map<String,String> getAllProperties(){

        Map<String,String> properties = new HashMap<>();
        String data = env.getProperty("database.numero.clientes");

        log.error("data: "+data);


        boolean d =  env.containsProperty("datasource1.datasource.url");
        log.error("d: "+d);

        boolean d2 =  env.containsProperty("datasource1.datasource");
        log.error("d2: "+d2);


            MyDatasource dataSource = env.getProperty("datasource1.datasource", MyDatasource.class, new MyDatasource());
            log.warn("url {}", dataSource.getUrl());
            log.warn("password {}", dataSource.getPassword());
            log.warn("username {}", dataSource.getUsername());
      
        

        return properties;
    }

    @Component
    @Data
    public class MyDatasource{

        private String url;
        private String password;
        private String username;

    }

}
