package com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper;

import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestauranteEntityMapper {
    RestauranteEntity toEntity(RestauranteObject restauranteObject);
    RestauranteObject toObject(RestauranteEntity restauranteEntity);
    List<RestauranteObject> toRestauranteModelList(List<RestauranteEntity> restauranteEntityList);
}
