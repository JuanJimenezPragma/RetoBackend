package com.pragma.retobackend.retobackend.infrastructure.output.jpa.adapter;

import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.domain.spi.ICuentaPersistencePort;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.ICuentaEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository.ICuentaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CuentaJpaAdapter implements ICuentaPersistencePort {

    private final ICuentaRepository cuentaRepository;
    private final ICuentaEntityMapper cuentaEntityMapper;

    @Override
    public void save(CuentaObject cuentaObject) {
        cuentaRepository.save(cuentaEntityMapper.toEntity(cuentaObject));
    }

    @Override
    public List<CuentaObject> getAll() {
        return cuentaEntityMapper.toCuentaModelList(cuentaRepository.findAll());
    }

    @Override
    public CuentaObject getCuentaByEmail(String email) {
        return cuentaEntityMapper.toModel(cuentaRepository.findByCorreo(email).orElse(null));
    }

    @Override
    public CuentaObject getById(Long id) {
        return cuentaEntityMapper.toModel(cuentaRepository.findById(id).orElse(null));
    }
}
