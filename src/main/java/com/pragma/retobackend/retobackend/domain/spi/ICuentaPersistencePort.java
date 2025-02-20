package com.pragma.retobackend.retobackend.domain.spi;

import com.pragma.retobackend.retobackend.domain.model.CuentaObject;

import java.util.List;

public interface ICuentaPersistencePort {
    void save(CuentaObject cuentaObject);
    List<CuentaObject> getAll();
    CuentaObject getCuentaByEmail(String username);
    CuentaObject getById(Long id);
}
