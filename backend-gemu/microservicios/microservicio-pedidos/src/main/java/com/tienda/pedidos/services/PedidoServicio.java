package com.tienda.pedidos.services;

import com.tienda.comun.models.Pedido;
import com.tienda.comun.models.Videojuego;
import com.tienda.comun.repositories.PedidoRepositorio;
import com.tienda.comun.repositories.VideojuegoRepositorio;
import com.tienda.pedidos.dto.DetallePedidoDTO;
import com.tienda.pedidos.dto.PedidoDTO;
import com.tienda.comun.models.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    @Autowired
    private VideojuegoRepositorio videojuegoRepositorio;

    @Value("${app.iva:0.21}")
    private BigDecimal ivaGlobal;

    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.findAll();
    }

    public Pedido crearPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();

        pedido.setUsuarioId(pedidoDTO.getUsuarioId());
        pedido.setMetodoPago(pedidoDTO.getMetodoPago());
        pedido.setDireccionEnvio(pedidoDTO.getDireccionEnvio());
        pedido.setFechaPedido(LocalDateTime.now());
        pedido.setEstadoEnvio(
                pedidoDTO.getEstadoEnvio() != null ? pedidoDTO.getEstadoEnvio() : "PENDIENTE"
        );

        BigDecimal totalSinIva = BigDecimal.ZERO;

        for (DetallePedidoDTO detalleDTO : pedidoDTO.getDetalles()) {
            Videojuego videojuego = videojuegoRepositorio.findById(detalleDTO.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Videojuego no encontrado"));

            DetallePedido detalle = new DetallePedido();
            detalle.setVideojuego(videojuego);
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setPrecioUnitario(detalleDTO.getPrecioUnitario());

            BigDecimal subtotalProducto = detalle.getPrecioUnitario()
                    .multiply(BigDecimal.valueOf(detalle.getCantidad()));
            detalle.setSubtotal(subtotalProducto);

            detalle.setPedido(pedido);
            pedido.getDetalles().add(detalle);
            totalSinIva = totalSinIva.add(subtotalProducto);
        }

        BigDecimal ivaTotal = totalSinIva.multiply(ivaGlobal);

        BigDecimal totalConIva = totalSinIva.add(ivaTotal);

        pedido.setTotalSinIva(totalSinIva);
        pedido.setTotalConIva(totalConIva);

        if (pedido.getIvaTotal().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El IVA no puede ser negativo");
        } else {
            pedido.setIvaTotal(ivaTotal);
        }

        return pedidoRepositorio.save(pedido);
    }

    public Pedido actualizarPedido(Long id, Pedido pedido) {
        Pedido pedidoExistente = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        pedidoExistente.setUsuarioId(pedido.getUsuarioId());
        pedidoExistente.setFechaPedido(pedido.getFechaPedido());
        pedidoExistente.setDireccionEnvio(pedido.getDireccionEnvio());
        pedidoExistente.setMetodoPago(pedido.getMetodoPago());
        pedidoExistente.setEstadoEnvio(pedido.getEstadoEnvio());
        pedidoExistente.setTotalSinIva(pedido.getTotalSinIva());
        pedidoExistente.setIvaTotal(pedido.getIvaTotal());
        pedidoExistente.setTotalConIva(pedido.getTotalConIva());
        return pedidoRepositorio.save(pedidoExistente);
    }

    public void eliminarPedido(Long id) {
        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedidoRepositorio.delete(pedido);
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepositorio.findById(id).orElse(null);
    }

    public List<Pedido> obtenerPedidoPorUsuario(Long usuarioId) {
        List<Pedido> pedidos = pedidoRepositorio.findByUsuarioId(usuarioId);
        for (Pedido pedido : pedidos) {
            pedidoRepositorio.findById(pedido.getId()).ifPresent(System.out::println);
        }
        return pedidos;
    }
}