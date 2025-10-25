package com.tienda.videojuegos.mappers;

import com.tienda.comun.models.Videojuego;
import com.tienda.videojuegos.dto.VideojuegoDTO;

public class VideojuegoMapper {

    public static VideojuegoDTO toDTO(Videojuego videojuego) {
        return new VideojuegoDTO(
                videojuego.getId(),
                videojuego.getNombre(),
                videojuego.getCodigo(),
                videojuego.getPrecio(),
                videojuego.getExistencias(),
                videojuego.getCategoria(),
                videojuego.getNum_jugadores(),
                videojuego.getEdad_recomendada(),
                videojuego.getPlataforma()
        );
    }

    public static Videojuego toEntity(VideojuegoDTO dto) {
        Videojuego usuario = new Videojuego();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setCodigo(dto.getCodigo());
        usuario.setPrecio(dto.getPrecio());
        usuario.setExistencias(dto.getExistencias());
        usuario.setCategoria(dto.getCategoria());
        usuario.setNum_jugadores(dto.getNum_jugadores());
        usuario.setEdad_recomendada(dto.getEdad_recomendada());
        usuario.setPlataforma(dto.getPlataforma());
        return usuario;
    }
}