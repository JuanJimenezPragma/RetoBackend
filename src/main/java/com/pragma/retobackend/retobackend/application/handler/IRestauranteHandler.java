package com.pragma.retobackend.retobackend.application.handler;

import com.pragma.retobackend.retobackend.application.dto.request.RestauranteRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.RestauranteResponseDto;

import java.util.List;

public interface IRestauranteHandler {
    void save(RestauranteRequestDto restauranteRequestDto);
    List<RestauranteResponseDto> getAll(int page, int size);
}
