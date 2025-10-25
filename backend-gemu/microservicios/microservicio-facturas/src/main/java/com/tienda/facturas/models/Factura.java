package com.tienda.facturas.models;

import com.tienda.comun.models.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_emision")
    @NotNull
    private LocalDateTime fechaEmision;

    @Column(name = "numero_factura")
    @NotNull
    private String numeroFactura;

    @Column(name = "estado")
    @NotNull
    private String estado = "GENERADA";

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;
}