package com.pragma.retobackend.retobackend.domain.api;

import com.pragma.retobackend.retobackend.domain.model.CuentaObject;

import java.util.List;

public interface ICuentaServicePort {
    void save(CuentaObject cuentaObject);
    List<CuentaObject> getAll();
    CuentaObject getCuentaByCorreoAndPassword(String correo, String password);
    CuentaObject getById(Long id);
    void createEmployeed(CuentaObject cuentaObject, String usuario);
    void createClient(CuentaObject cuentaObject);
    CuentaObject getCuentaByEmail(String email);
}
