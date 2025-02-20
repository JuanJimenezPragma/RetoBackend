package com.pragma.retobackend.retobackend.domain.usecase;

import com.pragma.retobackend.retobackend.domain.api.IPedidoServicePort;
import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.exception.DomainException;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.domain.model.PedidoObject;
import com.pragma.retobackend.retobackend.domain.spi.ICuentaPersistencePort;
import com.pragma.retobackend.retobackend.domain.spi.IPedidoPersistencePort;

import java.util.List;
import java.util.Objects;

public class PedidoUseCase implements IPedidoServicePort {

    private final IPedidoPersistencePort pedidoPersistencePort;
    private final ICuentaPersistencePort cuentaPersistencePort;

    public PedidoUseCase(IPedidoPersistencePort pedidoPersistencePort, ICuentaPersistencePort cuentaPersistencePort) {
        this.pedidoPersistencePort = pedidoPersistencePort;
        this.cuentaPersistencePort = cuentaPersistencePort;
    }

    @Override
    public void save(PedidoObject pedido, String usuario) {
        validatePedido(usuario);
        pedido.setEstado(PedidoEstadoEnum.PENDIENTE);
        pedido.setCliente(cuentaPersistencePort.getCuentaByEmail(usuario));
        pedidoPersistencePort.save(pedido);
    }

    @Override
    public List<PedidoObject> getByStatus(PedidoEstadoEnum estado,int page, int size, String usuario) {
        CuentaObject cuenta = cuentaPersistencePort.getCuentaByEmail(usuario);
        return pedidoPersistencePort.getByStatus(estado,page,size, cuenta.getRestaurante());
    }

    @Override
    public List<PedidoObject> asignPedido(Long pedidoId, PedidoEstadoEnum estado, int page, int size, String usuario) {
        PedidoObject pedido = pedidoPersistencePort.getById(pedidoId);
        CuentaObject cuenta = cuentaPersistencePort.getCuentaByEmail(usuario);
        validatePedidoAndRestaurante(pedido,cuenta);
        pedido.setEmpleadoAsignado(cuenta);
        pedido.setEstado(PedidoEstadoEnum.EN_PREPARACION);
        pedidoPersistencePort.save(pedido);
        return pedidoPersistencePort.getByStatus(estado,page,size,cuenta.getRestaurante());
    }

    public void validatePedido(String usuario){
        CuentaObject cuenta = cuentaPersistencePort.getCuentaByEmail(usuario);
        if(!pedidoPersistencePort.getByStatus(PedidoEstadoEnum.EN_PROCESO,0,5, cuenta.getRestaurante()).isEmpty()){
            throw new DomainException("Tiene un pedido en proceso");
        }
    }
    public void validatePedidoAndRestaurante(PedidoObject pedido, CuentaObject cuenta){

        if (!Objects.equals(pedido.getRestaurante().getId(), cuenta.getRestaurante().getId())){
            throw new DomainException("Pedido no corresponde a tu restaurante.");
        }
    }

}
