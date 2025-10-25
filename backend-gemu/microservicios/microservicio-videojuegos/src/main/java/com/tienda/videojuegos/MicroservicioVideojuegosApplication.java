package com.tienda.videojuegos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.tienda.videojuegos", "com.tienda.comun"})
@EnableJpaRepositories(basePackages = "com.tienda.comun.repositories")
@EntityScan(basePackages = "com.tienda.comun.models, com.tienda.videojuegos.models")
public class MicroservicioVideojuegosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioVideojuegosApplication.class, args);
	}
}