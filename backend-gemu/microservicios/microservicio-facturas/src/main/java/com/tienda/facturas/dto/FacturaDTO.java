package com.tienda.facturas.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacturaDTO {
    private Long id;
    private Long pedidoId;
    private String numeroFactura;
    private String estado;
    private LocalDateTime fechaEmision;
}