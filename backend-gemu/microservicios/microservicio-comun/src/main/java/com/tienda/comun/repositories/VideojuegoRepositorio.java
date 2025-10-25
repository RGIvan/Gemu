package com.tienda.comun.repositories;

import com.tienda.comun.models.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VideojuegoRepositorio extends JpaRepository<Videojuego, Long> {

    List<Videojuego> findByPrecioLessThanEqual(Double precio);
    List<Videojuego> findByPrecioGreaterThanEqual(Double precio);
    List<Videojuego> findByNombreContainingIgnoreCase(String nombre);
}