package com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity;

import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="pedido")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private RestauranteEntity restaurante;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoDetalleEntity> pedidoDetalle;

    @Enumerated(EnumType.STRING)
    private PedidoEstadoEnum estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private CuentaEntity cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private CuentaEntity empleadoAsignado;
}
