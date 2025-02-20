package com.pragma.retobackend.retobackend.application.dto.response;

import com.pragma.retobackend.retobackend.domain.enums.PlatoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlatoResponseDto {
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String urlImagen;
    private PlatoCategoriaEnum categoria;
    private PlatoEstadoEnum estado;
    private RestauranteResponseDto restaurante;
}
