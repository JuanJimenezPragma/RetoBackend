package com.pragma.retobackend.retobackend.application.dto.request;

import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.model.PedidoDetalleObject;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Pageable;
import java.util.List;

@Getter
@Setter
public class PedidoRequestDto {
    private Long id;
    private RestauranteObject restaurante;
    private List<PedidoDetalleObject> pedidoDetalle;
    private PedidoEstadoEnum estado;
    private PageRequestDto pageRequestDto;
}
