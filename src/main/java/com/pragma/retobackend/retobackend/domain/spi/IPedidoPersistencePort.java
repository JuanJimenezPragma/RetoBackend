package com.pragma.retobackend.retobackend.domain.spi;

import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.domain.model.PedidoObject;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;

import java.util.List;

public interface IPedidoPersistencePort {
    void save(PedidoObject pedido);
    PedidoObject getById(Long id);
    List<PedidoObject> getByStatus(PedidoEstadoEnum estado, int page, int size, RestauranteObject restaurante);
    List<PedidoObject> getByStatusAndCliente(PedidoEstadoEnum estado, int page, int size, RestauranteObject restaurante, CuentaObject cliente);
}
