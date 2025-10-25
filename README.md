# Tienda de Videojuegos – Microservicio de Pedidos y Facturación

Este proyecto es un microservicio de **gestión de pedidos** y **generación de facturas** para una **tienda de videojuegos**, desarrollado con **Spring Boot**, **JPA/Hibernate** y **PostgreSQL**.  

El sistema incluye las siguientes entidades principales:

- **Usuario**: información de clientes de la tienda.  
- **Videojuego**: catálogo de productos disponibles.  
- **Pedido**: pedidos realizados por los usuarios, con detalles de los productos comprados.  
- **DetallePedido**: detalle de cada producto dentro de un pedido.  
- **Factura**: documento contable generado automáticamente para cada pedido.

---

Estructura del Proyecto

```text
src/main/java/com/tienda/pedidos/
├── clients/           # Clientes para APIs externas (opcional)
├── dto/               # Data Transfer Objects (PedidoDTO, DetallePedidoDTO)
├── models/            # Entidades JPA (Pedido, DetallePedido, Factura)
├── repositories/      # Repositorios Spring Data JPA
├── services/          # Lógica de negocio
├── controllers/       # Endpoints REST
└── MicroservicioPedidosApplication.java
