package com.tienda.facturas.repositories;

import com.tienda.facturas.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    List<Factura> findByPedidoId(Long pedidoId);
}