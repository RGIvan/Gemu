package com.tienda.videojuegos.dto;

import lombok.Getter;

@Getter
public class NombreVideojuegoDTO {

    private String nombre;

    public NombreVideojuegoDTO(String nombre) {
        this.nombre = nombre;
    }
}