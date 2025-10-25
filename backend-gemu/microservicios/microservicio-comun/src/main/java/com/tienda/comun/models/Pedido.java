package com.tienda.comun.models;

import com.tienda.comun.models.DetallePedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    @NotNull
    private Long usuarioId;

    @Column(name = "fecha_pedido")
    @NotNull
    private LocalDateTime fechaPedido = LocalDateTime.now();

    @Column(name = "direccion_envio")
    @NotNull
    @Size(min = 2, max = 50)
    private String direccionEnvio;

    @Column(name = "metodo_pago")
    @NotNull
    @Size(min = 2, max = 20)
    private String metodoPago;

    @Column(name = "estado")
    @NotNull
    @Size(min = 2, max = 20)
    private String estadoEnvio;

    @Column(name = "total_sin_iva", precision = 10, scale = 2)
    @NotNull
    private BigDecimal totalSinIva = BigDecimal.ZERO;

    @Column(name = "iva_total", precision = 10, scale = 2)
    @NotNull
    private BigDecimal ivaTotal = BigDecimal.ZERO;

    @Column(name = "total_con_iva", precision = 10, scale = 2)
    @NotNull
    private BigDecimal totalConIva = BigDecimal.ZERO;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();
}