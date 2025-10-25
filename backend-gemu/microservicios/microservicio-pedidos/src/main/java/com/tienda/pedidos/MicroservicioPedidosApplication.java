package com.tienda.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
        "com.tienda.pedidos.repositories",
        "com.tienda.comun.repositories"
})
@EntityScan(basePackages = {
        "com.tienda.pedidos.models",
        "com.tienda.comun.models"
})
public class MicroservicioPedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioPedidosApplication.class, args);
    }
}
