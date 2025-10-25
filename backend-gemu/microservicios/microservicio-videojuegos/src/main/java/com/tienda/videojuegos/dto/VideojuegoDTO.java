package com.tienda.videojuegos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideojuegoDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private float precio;
    private int existencias;
    private String categoria;
    private int num_jugadores;
    private int edad_recomendada;
    private String plataforma;
}