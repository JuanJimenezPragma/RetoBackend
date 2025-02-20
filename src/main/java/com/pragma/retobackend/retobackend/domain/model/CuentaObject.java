package com.pragma.retobackend.retobackend.domain.model;

import com.pragma.retobackend.retobackend.domain.enums.RolCuentaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuentaObject {
    private Long id;
    private RolCuentaEnum rol;
    private String nombre;
    private String apellido;
    private Long documentoDeIdentidad;
    private String telefono;
    private LocalDate fechaDeNacimiento;
    private String correo;
    private String clave;
    private RestauranteObject restaurante;
}
