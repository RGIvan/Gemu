package com.tienda.comun.models;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "videojuegos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull
    @Size(min = 8, max = 20)
    private String codigo;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String nombre;

    @Column(nullable = false)
    @NotNull
    private float precio;

    @Column(nullable = false)
    @NotNull
    private int existencias;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String categoria;

    @Column(nullable = false)
    private int num_jugadores;

    @Column(nullable = false)
    private int edad_recomendada;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String plataforma;
}