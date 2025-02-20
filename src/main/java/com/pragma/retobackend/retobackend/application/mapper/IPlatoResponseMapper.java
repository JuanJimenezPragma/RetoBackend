package com.pragma.retobackend.retobackend.application.mapper;

import com.pragma.retobackend.retobackend.application.dto.response.PlatoResponseDto;
import com.pragma.retobackend.retobackend.domain.model.PlatoObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPlatoResponseMapper {
    PlatoResponseDto toResponse(PlatoObject platoObject);
    List<PlatoResponseDto> toResponseList(List<PlatoObject> platoObjectList);
}
