package com.tienda.facturas.mappers;

import com.tienda.facturas.dto.FacturaDTO;
import com.tienda.facturas.models.Factura;

public class FacturaMapper {
    public static FacturaDTO toDTO(Factura factura) {
        FacturaDTO dto = new FacturaDTO();
        dto.setId(factura.getId());
        dto.setPedidoId(factura.getPedido().getId());
        dto.setNumeroFactura(factura.getNumeroFactura());
        dto.setEstado(factura.getEstado());
        dto.setFechaEmision(factura.getFechaEmision());
        return dto;
    }
}