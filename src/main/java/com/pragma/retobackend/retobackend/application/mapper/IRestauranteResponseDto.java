package com.pragma.retobackend.retobackend.application.mapper;

import com.pragma.retobackend.retobackend.application.dto.request.RestauranteRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.RestauranteResponseDto;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestauranteResponseDto {
    RestauranteRequestDto toResponse(RestauranteObject restauranteObject);
    List<RestauranteResponseDto> toResponseList(List<RestauranteObject> restauranteObjectList);
}
