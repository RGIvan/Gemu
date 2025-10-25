package com.tienda.videojuegos.services;

import com.tienda.comun.models.Videojuego;
import com.tienda.comun.repositories.VideojuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoServicio {

    @Autowired
    private VideojuegoRepositorio videojuegoRepositorio;

    public List<Videojuego> listarVideojuegos() {
        return videojuegoRepositorio.findAll();
    }

    public Videojuego crearVideojuego(Videojuego videojuego) {
        return videojuegoRepositorio.save(videojuego);
    }

    public Videojuego actualizarVideojuego(Long id, Videojuego videojuegoActualizado){

        Videojuego videojuegoExistente = videojuegoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Videojuego no encontrado"));

        videojuegoExistente.setCodigo(videojuegoActualizado.getCodigo());
        videojuegoExistente.setNombre(videojuegoActualizado.getNombre());
        videojuegoExistente.setPrecio(videojuegoActualizado.getPrecio());
        videojuegoExistente.setExistencias(videojuegoActualizado.getExistencias());
        videojuegoExistente.setCategoria(videojuegoActualizado.getCategoria());
        videojuegoExistente.setNum_jugadores(videojuegoActualizado.getNum_jugadores());
        videojuegoExistente.setEdad_recomendada(videojuegoActualizado.getEdad_recomendada());
        videojuegoExistente.setPlataforma(videojuegoActualizado.getPlataforma());

        return videojuegoRepositorio.save(videojuegoExistente);
    }

    public void eliminarVideojuego(Long id) {
        videojuegoRepositorio.deleteById(id);
    }

    public Videojuego buscarVideojuegoPorNombre(String nombre) {
        return videojuegoRepositorio.findByNombreContainingIgnoreCase(nombre).stream().findFirst().orElse(null);
    }

    public List<Videojuego> buscarVideojuegosPorPrecioMenorQue(Double precio) {
        return videojuegoRepositorio.findByPrecioLessThanEqual(precio);
    }

    public List<Videojuego> buscarVideojuegosPorPrecioMayorQue(Double precio) {
        return videojuegoRepositorio.findByPrecioGreaterThanEqual(precio);
    }
}