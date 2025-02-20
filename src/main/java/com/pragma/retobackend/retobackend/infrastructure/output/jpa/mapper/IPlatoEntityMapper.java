package com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper;

import com.pragma.retobackend.retobackend.domain.model.PlatoObject;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.PlatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlatoEntityMapper {
    PlatoEntity toEntity(PlatoObject plato);
    PlatoObject toModel(PlatoEntity plato);
    List<PlatoObject> toPlatoModelList(List<PlatoEntity> platoEntityList);
}