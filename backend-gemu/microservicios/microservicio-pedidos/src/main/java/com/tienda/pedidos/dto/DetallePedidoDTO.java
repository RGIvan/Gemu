package com.tienda.pedidos.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetallePedidoDTO {
    private Long id;
    private Long productoId;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
