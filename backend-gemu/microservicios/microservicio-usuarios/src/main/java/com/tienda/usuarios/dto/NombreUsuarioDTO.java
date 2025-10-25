package com.tienda.usuarios.dto;

import lombok.Getter;

@Getter
public class NombreUsuarioDTO {
    private String nombre;

    public NombreUsuarioDTO(String nombre) {
        this.nombre = nombre;
    }
}