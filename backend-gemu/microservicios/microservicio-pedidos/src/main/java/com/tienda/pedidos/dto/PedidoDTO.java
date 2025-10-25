package com.tienda.pedidos.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;
    private Long usuarioId;
    private LocalDateTime fechaPedido;
    private String direccionEnvio;
    private String metodoPago;
    private String estadoEnvio;
    private BigDecimal totalSinIva;
    private BigDecimal ivaTotal;
    private BigDecimal totalConIva;
    private List<DetallePedidoDTO> detalles = new ArrayList<>();
}