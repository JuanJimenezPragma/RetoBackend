package com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper;

import com.pragma.retobackend.retobackend.domain.model.PedidoObject;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoEntityMapper {
    PedidoEntity toEntity(PedidoObject pedidoObject);
    PedidoObject toObject(PedidoEntity pedidoEntity);
    List<PedidoObject> toPedidoModelList(List<PedidoEntity> pedidoEntityList);
}
