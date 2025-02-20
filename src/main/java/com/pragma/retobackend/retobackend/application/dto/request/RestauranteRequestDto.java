package com.pragma.retobackend.retobackend.application.dto.request;

import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteRequestDto {
    private String nombre;
    private Long nit;
    private String direccion;
    private String telefono;
    private String urlLogo;
    private int page;
    private int size;
}
