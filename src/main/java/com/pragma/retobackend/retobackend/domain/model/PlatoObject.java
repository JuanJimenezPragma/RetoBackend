package com.pragma.retobackend.retobackend.domain.model;

import com.pragma.retobackend.retobackend.domain.enums.PlatoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatoObject {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String urlImagen;
    private PlatoCategoriaEnum categoria;
    private PlatoEstadoEnum estado;
    private RestauranteObject restaurante;
}
