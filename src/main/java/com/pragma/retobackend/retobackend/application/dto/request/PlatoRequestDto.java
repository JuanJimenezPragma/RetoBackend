package com.pragma.retobackend.retobackend.application.dto.request;

import com.pragma.retobackend.retobackend.domain.enums.PlatoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlatoRequestDto {
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private PlatoEstadoEnum estado;
    private String urlImagen;
    private PlatoCategoriaEnum categoria;
    private Long restauranteId;
    private RestauranteObject restaurante;
    private PageRequestDto pageable;
}
