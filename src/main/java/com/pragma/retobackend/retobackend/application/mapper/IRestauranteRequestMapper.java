package com.pragma.retobackend.retobackend.application.mapper;

import com.pragma.retobackend.retobackend.application.dto.request.RestauranteRequestDto;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestauranteRequestMapper {
    RestauranteObject toRestaurante(RestauranteRequestDto restauranteRequestDto);
}
