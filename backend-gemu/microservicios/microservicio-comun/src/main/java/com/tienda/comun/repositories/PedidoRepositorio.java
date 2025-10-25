package com.tienda.comun.repositories;

import com.tienda.comun.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuarioId(Long usuarioId);
    Optional<Pedido> findById(Long pedidoId);
}