package com.pragma.retobackend.retobackend.domain.api;

import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;

import java.util.List;

public interface IRestauranteServicePort {
    void save(RestauranteObject restaurante);
    List<RestauranteObject> getAll(int page, int size);
    RestauranteObject getRestauranteById(Long id);
}
