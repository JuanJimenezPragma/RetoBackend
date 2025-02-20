package com.pragma.retobackend.retobackend.application.mapper;

import com.pragma.retobackend.retobackend.application.dto.response.PedidoResponseDto;
import com.pragma.retobackend.retobackend.domain.model.PedidoObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoResponseMapper {
    PedidoResponseDto toResponse(PedidoObject pedido);
    List<PedidoResponseDto> toResponseList(List<PedidoObject> pedidoList);
}
