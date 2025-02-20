package com.pragma.retobackend.retobackend.application.mapper;

import com.pragma.retobackend.retobackend.application.dto.request.CuentaRequestDto;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICuentaRequestMapper {
    CuentaObject toCuenta(CuentaRequestDto cuentaRequestDto);
}
