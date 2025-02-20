package com.pragma.retobackend.retobackend.application.handler;

import com.pragma.retobackend.retobackend.application.dto.request.PedidoRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.PedidoResponseDto;
import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;

import java.util.List;

public interface IPedidoHandler {
    void save(PedidoRequestDto pedido, String usuario);
    List<PedidoResponseDto> getByStatus(PedidoEstadoEnum estado, int page, int size, String usuario);
    List<PedidoResponseDto> pedidoAsign(Long pedidoId, PedidoEstadoEnum estado, int page, int size, String usuario);
}
