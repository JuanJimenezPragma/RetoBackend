package com.pragma.retobackend.retobackend.infrastructure.output.jpa.adapter;

import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.domain.model.PedidoObject;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import com.pragma.retobackend.retobackend.domain.spi.IPedidoPersistencePort;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.PedidoDetalleEntity;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.PedidoEntity;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.ICuentaEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.IPedidoEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository.IPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class PedidoJpaAdapter implements IPedidoPersistencePort {

    private final IPedidoRepository pedidoRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;
    private final ICuentaEntityMapper cuentaEntityMapper;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    @Override
    public void save(PedidoObject pedido) {
        PedidoEntity pedidoEntity = pedidoEntityMapper.toEntity(pedido);
        for (PedidoDetalleEntity pedidoDetalleEntity : pedidoEntity.getPedidoDetalle()){
            pedidoDetalleEntity.setPedido(pedidoEntity);
        }
        pedidoRepository.save(pedidoEntity);
    }

    @Override
    public PedidoObject getById(Long id) {
        return pedidoEntityMapper.toObject(pedidoRepository.findById(id).orElse(null));
    }

    @Override
    public List<PedidoObject> getByStatus(PedidoEstadoEnum estado, int page, int size, RestauranteObject restaurante) {
        Pageable pageable = PageRequest.of(page,size);
        return pedidoEntityMapper.toPedidoModelList(pedidoRepository.findByEstadoAndRestaurante(estado,pageable, restauranteEntityMapper.toEntity(restaurante)));
    }

    @Override
    public List<PedidoObject> getByStatusAndCliente(PedidoEstadoEnum estado, int page, int size, RestauranteObject restaurante, CuentaObject cliente) {
        Pageable pageable = PageRequest.of(page,size);
        return pedidoEntityMapper.toPedidoModelList(pedidoRepository.findByEstadoAndRestauranteAndCliente(estado,pageable, restaurante, cuentaEntityMapper.toEntity(cliente)));
    }
}
