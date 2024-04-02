package com.sri.procesamiento.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="datasource1.datasource")
@Data
public class DataSourceOneConfig {
    private String url;
	private String password;
	private String username;
}
