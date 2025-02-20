package com.pragma.retobackend.retobackend.application.handler;

import com.pragma.retobackend.retobackend.application.dto.request.CuentaRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.CuentaResponseDto;

import java.util.List;

public interface ICuentaHandler {
    void save(CuentaRequestDto cuentaRequestDto);
    List<CuentaResponseDto> obtenerCuentas();
    CuentaResponseDto obtenerCuentaByEmailAndPassword(String email, String password);
    void createEmployeed(CuentaRequestDto cuentaRequestDto, String usuario);
    void createClient(CuentaRequestDto cuentaRequestDto);
}
