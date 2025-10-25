package com.tienda.pedidos.mappers;

import com.tienda.comun.models.Pedido;
import com.tienda.pedidos.dto.DetallePedidoDTO;
import com.tienda.pedidos.dto.PedidoDTO;
import com.tienda.comun.models.DetallePedido;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoDTO toPedidoDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setUsuarioId(pedido.getUsuarioId());
        dto.setFechaPedido(pedido.getFechaPedido());
        dto.setDireccionEnvio(pedido.getDireccionEnvio());
        dto.setMetodoPago(pedido.getMetodoPago());
        dto.setEstadoEnvio(pedido.getEstadoEnvio());
        dto.setTotalSinIva(pedido.getTotalSinIva());
        dto.setIvaTotal(pedido.getIvaTotal());
        dto.setTotalConIva(pedido.getTotalConIva());
        dto.setDetalles(pedido.getDetalles().stream()
              .map(PedidoMapper::toDetallePedidoDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public static DetallePedidoDTO toDetallePedidoDTO(DetallePedido detalle) {
        DetallePedidoDTO dto = new DetallePedidoDTO();
        dto.setId(detalle.getId());
        dto.setProductoId(detalle.getVideojuego().getId());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());
        return dto;
    }
}