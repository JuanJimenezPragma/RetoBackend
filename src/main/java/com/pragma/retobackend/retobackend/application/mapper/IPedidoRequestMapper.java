package com.pragma.retobackend.retobackend.application.mapper;

import com.pragma.retobackend.retobackend.application.dto.request.PedidoRequestDto;
import com.pragma.retobackend.retobackend.domain.model.PedidoObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoRequestMapper {
    PedidoObject toPedido(PedidoRequestDto pedido);
}
