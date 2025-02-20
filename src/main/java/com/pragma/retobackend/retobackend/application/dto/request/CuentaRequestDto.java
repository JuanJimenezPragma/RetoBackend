package com.pragma.retobackend.retobackend.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CuentaRequestDto {
    private String nombre;
    private String apellido;
    private Long documentoDeIdentidad;
    private String telefono;
    private LocalDate fechaDeNacimiento;
    private String correo;
    private String clave;
    private Long idRestaurante;

}
