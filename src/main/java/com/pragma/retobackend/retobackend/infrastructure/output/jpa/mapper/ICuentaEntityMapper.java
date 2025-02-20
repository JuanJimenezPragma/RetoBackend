package com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper;

import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.CuentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICuentaEntityMapper {
    CuentaEntity toEntity(CuentaObject cuentaObject);
    CuentaObject toModel(CuentaEntity cuentaEntity);
    List<CuentaObject> toCuentaModelList(List<CuentaEntity> cuentaEntityList);
}
