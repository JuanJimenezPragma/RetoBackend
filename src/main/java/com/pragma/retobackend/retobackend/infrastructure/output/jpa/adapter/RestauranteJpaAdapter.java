package com.pragma.retobackend.retobackend.infrastructure.output.jpa.adapter;

import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import com.pragma.retobackend.retobackend.domain.spi.IRestaurantePersistencePort;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class RestauranteJpaAdapter implements IRestaurantePersistencePort {

    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    @Override
    public void save(RestauranteObject restaurante) {
        restauranteRepository.save(restauranteEntityMapper.toEntity(restaurante));
    }

    @Override
    public List<RestauranteObject> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return restauranteEntityMapper.toRestauranteModelList(restauranteRepository.findAll(pageable).stream().toList());
    }

    @Override
    public RestauranteObject getRestauranteById(Long id) {
        return restauranteEntityMapper.toObject(restauranteRepository.findById(id).orElse(null));
    }
}
