package com.pragma.retobackend.retobackend.application.handler;

import com.pragma.retobackend.retobackend.application.dto.request.PedidoRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.PedidoResponseDto;
import com.pragma.retobackend.retobackend.application.mapper.IPedidoRequestMapper;
import com.pragma.retobackend.retobackend.application.mapper.IPedidoResponseMapper;
import com.pragma.retobackend.retobackend.domain.api.IPedidoServicePort;
import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PedidoHandler implements IPedidoHandler{

    private final IPedidoServicePort pedidoServicePort;
    private final IPedidoRequestMapper pedidoRequestMapper;
    private final IPedidoResponseMapper pedidoResponseMapper;

    @Override
    public void save(PedidoRequestDto pedido, String usuairo) {
        pedidoServicePort.save(pedidoRequestMapper.toPedido(pedido), usuairo);
    }

    @Override
    public List<PedidoResponseDto> getByStatus(PedidoEstadoEnum estado, int page, int size, String usuario) {
        return pedidoResponseMapper.toResponseList(pedidoServicePort.getByStatus(estado,page,size, usuario));
    }

    @Override
    public List<PedidoResponseDto> pedidoAsign(Long pedidoId, PedidoEstadoEnum estado, int page, int size, String usuario) {
        return pedidoResponseMapper.toResponseList(pedidoServicePort.asignPedido(pedidoId,estado,page,size,usuario));
    }
}
