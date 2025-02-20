package com.pragma.retobackend.retobackend.application.mapper;

import com.pragma.retobackend.retobackend.application.dto.request.PlatoRequestDto;
import com.pragma.retobackend.retobackend.domain.model.PlatoObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPlatoRequestMapper {
    PlatoObject toPlato(PlatoRequestDto platoRequestDto);
}
