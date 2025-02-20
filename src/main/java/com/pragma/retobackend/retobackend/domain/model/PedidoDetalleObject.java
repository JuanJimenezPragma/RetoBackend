package com.pragma.retobackend.retobackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDetalleObject {
    private Long id;
    private PlatoObject plato;
    private int cantidad;
}
