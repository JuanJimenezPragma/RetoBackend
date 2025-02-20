package com.pragma.retobackend.retobackend.domain.api;

import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.model.PedidoObject;

import java.util.List;

public interface IPedidoServicePort {
    void save(PedidoObject pedido, String usuario);
    List<PedidoObject> getByStatus(PedidoEstadoEnum estado, int page, int size, String usuario);
    List<PedidoObject> asignPedido(Long pedidoId, PedidoEstadoEnum estado, int page, int size, String usuario);
}
