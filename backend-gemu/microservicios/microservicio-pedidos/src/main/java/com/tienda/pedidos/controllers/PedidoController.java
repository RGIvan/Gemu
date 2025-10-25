package com.tienda.pedidos.controllers;

import com.tienda.comun.models.Pedido;
import com.tienda.pedidos.dto.PedidoDTO;
import com.tienda.pedidos.mappers.PedidoMapper;
import com.tienda.pedidos.services.PedidoServicio;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoServicio pedidoServicio;

    public PedidoController(PedidoServicio PedidoServicio) {
        this.pedidoServicio = PedidoServicio;
    }

    @GetMapping
    public List<PedidoDTO> listarPedidos() {
        return pedidoServicio.listarPedidos()
                .stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/crear")
    public PedidoDTO crearPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido nuevoPedido = pedidoServicio.crearPedido(pedidoDTO);
        return PedidoMapper.toPedidoDTO(nuevoPedido);
    }

    @PutMapping("/actualizar/{id}")
    public PedidoDTO actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido pedidoActualizado = pedidoServicio.actualizarPedido(id, pedido);
        return PedidoMapper.toPedidoDTO(pedidoActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoServicio.eliminarPedido(id);
    }

    @GetMapping("/{id}")
    public PedidoDTO obtenerPedidoPorId(@PathVariable Long id) {
        Pedido pedido = pedidoServicio.obtenerPedidoPorId(id);
        return PedidoMapper.toPedidoDTO(pedido);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<PedidoDTO> obtenerPedidosPorUsuario(@PathVariable Long idUsuario) {
        return pedidoServicio.obtenerPedidoPorUsuario(idUsuario)
                .stream()
                .map(PedidoMapper::toPedidoDTO)
                .collect(Collectors.toList());
    }
}