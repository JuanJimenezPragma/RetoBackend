package com.pragma.retobackend.retobackend.domain.model;

import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoObject {
    private Long id;
    private RestauranteObject restaurante;
    private List<PedidoDetalleObject> pedidoDetalle;
    private PedidoEstadoEnum estado;
    private CuentaObject cliente;
    private CuentaObject empleadoAsignado;
}
