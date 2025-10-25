package com.tienda.pedidos.controllers;

import com.tienda.pedidos.dto.DetallePedidoDTO;
import com.tienda.pedidos.mappers.PedidoMapper;
import com.tienda.comun.models.DetallePedido;
import com.tienda.pedidos.services.DetallePedidoServicio;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/detalles")
public class DetallePedidoController {

    private final DetallePedidoServicio detallePedidoServicio;

    public DetallePedidoController(DetallePedidoServicio detallePedidoServicio) {
        this.detallePedidoServicio = detallePedidoServicio;
    }

    @PostMapping("/crear")
    public DetallePedidoDTO crearDetalle(@RequestBody DetallePedido detallePedido) {
        DetallePedido nuevoDetalle = detallePedidoServicio.crearDetalle(detallePedido);
        return PedidoMapper.toDetallePedidoDTO(nuevoDetalle);
    }

    @PutMapping("/actualizar/{id}")
    public DetallePedidoDTO actualizarDetalle(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        DetallePedido detallePedidoActualizado = detallePedidoServicio.actualizarDetalle(id, detallePedido);
        return PedidoMapper.toDetallePedidoDTO(detallePedidoActualizado);
    }


    @DeleteMapping("/{id}")
    public void eliminarDetalle(@PathVariable Long id) {
        detallePedidoServicio.eliminarDetalle(id);
    }

    @GetMapping
    public List<DetallePedidoDTO> listarDetalles() {
        return detallePedidoServicio.listarDetalles()
                .stream()
                .map(PedidoMapper::toDetallePedidoDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public List<DetallePedidoDTO> listarDetallesPorPedido(@RequestBody Long pedidoId) {
        return detallePedidoServicio.listarDetallesPorPedido(pedidoId)
                .stream()
                .map(PedidoMapper::toDetallePedidoDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DetallePedidoDTO obtenerDetallePorId(@PathVariable Long id) {
        DetallePedido detallePedido = detallePedidoServicio.obtenerDetallePorId(id);
        return PedidoMapper.toDetallePedidoDTO(detallePedido);
    }
}