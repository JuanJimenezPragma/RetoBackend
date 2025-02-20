package com.pragma.retobackend.retobackend.application.handler;

import com.pragma.retobackend.retobackend.application.dto.request.CuentaRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.CuentaResponseDto;
import com.pragma.retobackend.retobackend.application.mapper.ICuentaRequestMapper;
import com.pragma.retobackend.retobackend.application.mapper.ICuentaResponseMapper;
import com.pragma.retobackend.retobackend.domain.api.ICuentaServicePort;
import com.pragma.retobackend.retobackend.domain.api.IRestauranteServicePort;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CuentaHandler implements ICuentaHandler{

    private final ICuentaServicePort cuentaServicePort;
    private final ICuentaRequestMapper cuentaRequestMapper;
    private final ICuentaResponseMapper cuentaResponseMapper;
    private final IRestauranteServicePort restauranteServicePort;

    @Override
    public void save(CuentaRequestDto cuentaRequestDto) {
        CuentaObject cuenta = cuentaRequestMapper.toCuenta(cuentaRequestDto);
        RestauranteObject restaurante = restauranteServicePort.getRestauranteById(cuentaRequestDto.getIdRestaurante());
        cuenta.setRestaurante(restaurante);
        cuentaServicePort.save(cuenta);
    }

    @Override
    public List<CuentaResponseDto> obtenerCuentas() {
        return cuentaResponseMapper.toResponseList(cuentaServicePort.getAll());
    }

    @Override
    public CuentaResponseDto obtenerCuentaByEmailAndPassword(String email, String password) {
        return cuentaResponseMapper.toResponse(cuentaServicePort.getCuentaByCorreoAndPassword(email,password));
    }

    @Override
    public void createEmployeed(CuentaRequestDto cuentaRequestDto, String usuario) {
        cuentaServicePort.createEmployeed(cuentaRequestMapper.toCuenta(cuentaRequestDto), usuario);
    }

    @Override
    public void createClient(CuentaRequestDto cuentaRequestDto) {
        cuentaServicePort.createClient(cuentaRequestMapper.toCuenta(cuentaRequestDto));
    }
}
