package com.pragma.retobackend.retobackend.application.mapper;

import com.pragma.retobackend.retobackend.application.dto.response.CuentaResponseDto;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICuentaResponseMapper {
    CuentaResponseDto toResponse(CuentaObject cuentaObject);
    List<CuentaResponseDto> toResponseList(List<CuentaObject> cuentaObjects);
}
