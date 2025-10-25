package com.tienda.pedidos.services;

import com.tienda.comun.models.DetallePedido;
import com.tienda.pedidos.repositories.DetallePedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetallePedidoServicio {

    @Autowired
    private DetallePedidoRepositorio detallePedidoRepository;

    public List<DetallePedido> listarDetallesPorPedido(Long pedidoId) {
        return detallePedidoRepository.findByPedidoId(pedidoId);
    }

    public DetallePedido crearDetalle(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public DetallePedido actualizarDetalle(Long id, DetallePedido detallePedido) {
        DetallePedido detallePedidoExistente = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado"));

        detallePedidoExistente.setPedido(detallePedido.getPedido());
        detallePedidoExistente.setVideojuego(detallePedido.getVideojuego());
        detallePedidoExistente.setCantidad(detallePedido.getCantidad());
        detallePedidoExistente.setPrecioUnitario(detallePedido.getPrecioUnitario());
        detallePedidoExistente.setSubtotal(detallePedido.getSubtotal());
        return detallePedidoRepository.save(detallePedidoExistente);
    }

    public void eliminarDetalle(Long id) {
        detallePedidoRepository.deleteById(id);
    }

    public DetallePedido obtenerDetallePorId(Long id) {
        return detallePedidoRepository.findById(id).orElse(null);    }

    public List<DetallePedido> listarDetalles() {
        return detallePedidoRepository.findAll();
    }
}