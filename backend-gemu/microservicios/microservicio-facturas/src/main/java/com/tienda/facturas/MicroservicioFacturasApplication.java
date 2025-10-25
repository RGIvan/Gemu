package com.tienda.facturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
        "com.tienda.facturas.repositories",
        "com.tienda.comun.repositories"
})
@EntityScan(basePackages = {
        "com.tienda.facturas.models",
        "com.tienda.comun.models"
})
public class MicroservicioFacturasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioFacturasApplication.class, args);
	}
}