package com.pragma.retobackend.retobackend.domain.spi;

import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;

import java.util.List;

public interface IRestaurantePersistencePort {
    void save(RestauranteObject restaurante);
    List<RestauranteObject> getAll(int page, int size);
    RestauranteObject getRestauranteById(Long id);

}
