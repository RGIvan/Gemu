package com.tienda.comun.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Videojuego videojuego;

    @Column(name = "cantidad", nullable = false)
    @NotNull
    private Integer cantidad;

    @Column(name = "precio_unitario", precision = 10, scale = 2, nullable = false)
    @NotNull
    private BigDecimal precioUnitario;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    @NotNull
    private BigDecimal subtotal;
}