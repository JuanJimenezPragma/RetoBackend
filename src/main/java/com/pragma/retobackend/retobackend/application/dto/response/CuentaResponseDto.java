package com.pragma.retobackend.retobackend.application.dto.response;

import com.pragma.retobackend.retobackend.domain.enums.RolCuentaEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CuentaResponseDto {
    private String nombre;
    private RolCuentaEnum rol;
    private String apellido;
    private Long documentoDeIdentidad;
    private String telefono;
    private LocalDate fechaDeNacimiento;
    private String correo;
    private RestauranteResponseDto restaurante;

}
