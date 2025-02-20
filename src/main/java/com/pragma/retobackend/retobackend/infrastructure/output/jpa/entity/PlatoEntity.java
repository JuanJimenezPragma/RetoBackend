package com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity;

import com.pragma.retobackend.retobackend.domain.enums.PlatoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="plato")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String urlImagen;

    @Enumerated(EnumType.STRING)
    private PlatoCategoriaEnum categoria;

    @Enumerated(EnumType.STRING)
    private PlatoEstadoEnum estado;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private RestauranteEntity restaurante;
}
