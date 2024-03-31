package com.sri.procesamiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan("com.leon.estructura.persistencia.entidad")
@EnableJpaRepositories("com.leon.estructura.persistencia.crud")
public class ProcesamientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcesamientoApplication.class, args);
	}

}
