package com.pragma.retobackend.retobackend.application.dto.response;

import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.model.PedidoDetalleObject;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoResponseDto {
    private Long id;
    private List<PedidoDetalleObject> pedidoDetalle;
    private PedidoEstadoEnum estado;
}
