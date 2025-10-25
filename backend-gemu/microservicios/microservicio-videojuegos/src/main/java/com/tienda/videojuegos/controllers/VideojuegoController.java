package com.tienda.videojuegos.controllers;

import com.tienda.videojuegos.dto.NombreVideojuegoDTO;
import com.tienda.videojuegos.dto.VideojuegoDTO;
import com.tienda.videojuegos.mappers.VideojuegoMapper;
import com.tienda.comun.models.Videojuego;
import com.tienda.videojuegos.services.VideojuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    @Autowired
    private final VideojuegoServicio videojuegoServicio;

    public VideojuegoController(VideojuegoServicio videojuegoServicio) {
        this.videojuegoServicio = videojuegoServicio;
    }

    @GetMapping
    public List<VideojuegoDTO> listarVideojuegos() {
        List<Videojuego> videojuegos = videojuegoServicio.listarVideojuegos();
        return videojuegos.stream()
                .map(VideojuegoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/crear")
    public VideojuegoDTO crearVideojuego(@RequestBody VideojuegoDTO videojuegoDTO) {
        Videojuego videojuego = VideojuegoMapper.toEntity(videojuegoDTO);
        Videojuego nuevoVideojuego = videojuegoServicio.crearVideojuego(videojuego);
        return VideojuegoMapper.toDTO(nuevoVideojuego);
    }

    @PutMapping("/actualizar/{id}")
    public VideojuegoDTO actualizarVideojuego(@PathVariable Long id, @RequestBody VideojuegoDTO videojuegoDTO) {
        Videojuego videojuegoActualizado = videojuegoServicio.actualizarVideojuego(id, VideojuegoMapper.toEntity(videojuegoDTO));
        return VideojuegoMapper.toDTO(videojuegoActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarVideojuego(@PathVariable Long id) {
        videojuegoServicio.eliminarVideojuego(id);
    }

    @PostMapping("/buscar")
    public NombreVideojuegoDTO buscarVideojuegoPorNombre(@RequestBody NombreVideojuegoDTO dto) {
        System.out.println("Buscando por nombre: " + dto.getNombre());
        Videojuego videojuego = videojuegoServicio.buscarVideojuegoPorNombre(dto.getNombre());
        return new NombreVideojuegoDTO(videojuego.getNombre());
    }

    @PostMapping("/buscar/precioMenor")
    public List<Videojuego> buscarVideojuegosPorPrecioMenorQue(@RequestBody Double precio) {
        return videojuegoServicio.buscarVideojuegosPorPrecioMenorQue(precio);
    }

    @PostMapping("/buscar/precioMayor")
    public List<Videojuego> buscarVideojuegosPorPrecioMayorQue(@RequestBody Double precio) {
        return videojuegoServicio.buscarVideojuegosPorPrecioMayorQue(precio);
    }
}