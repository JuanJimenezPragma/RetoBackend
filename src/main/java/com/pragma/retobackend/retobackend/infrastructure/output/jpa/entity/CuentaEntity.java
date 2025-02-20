package com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity;

import com.pragma.retobackend.retobackend.domain.enums.RolCuentaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="cuenta")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolCuentaEnum rol;
    private String nombre;
    private String apellido;
    private Long documentoDeIdentidad;
    private String telefono;
    private LocalDate fechaDeNacimiento;
    private String correo;
    private String clave;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private RestauranteEntity restaurante;

}
