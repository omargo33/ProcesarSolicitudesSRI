package com.sri.procesamiento.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix="datasource1.datasource")
@Getter
@Setter
public class DataSourceOneConfig {
    private String url;
	private String password;
	private String username;
}