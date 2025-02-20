package com.pragma.retobackend.retobackend.application.handler;

import com.pragma.retobackend.retobackend.application.dto.request.RestauranteRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.RestauranteResponseDto;
import com.pragma.retobackend.retobackend.application.mapper.IRestauranteRequestMapper;
import com.pragma.retobackend.retobackend.application.mapper.IRestauranteResponseDto;
import com.pragma.retobackend.retobackend.domain.api.ICuentaServicePort;
import com.pragma.retobackend.retobackend.domain.api.IRestauranteServicePort;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RestauranteHandler implements IRestauranteHandler{

    private final IRestauranteServicePort restauranteServicePort;
    private final ICuentaServicePort cuentaServicePort;
    private final IRestauranteRequestMapper restauranteRequestMapper;
    private final IRestauranteResponseDto restauranteResponseDto;

    @Override
    public void save(RestauranteRequestDto restauranteRequestDto) {
        restauranteServicePort.save(restauranteRequestMapper.toRestaurante(restauranteRequestDto));
    }

    @Override
    public List<RestauranteResponseDto> getAll(int page, int size) {
        return restauranteResponseDto.toResponseList(restauranteServicePort.getAll(page,size));
    }
}
