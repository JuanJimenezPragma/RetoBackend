package com.pragma.retobackend.retobackend.domain.spi;

import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import com.pragma.retobackend.retobackend.domain.model.PlatoObject;

import java.util.List;

public interface IPlatoPersistencePort {
    void save(PlatoObject plato);
    PlatoObject update(PlatoObject plato);
    PlatoObject getById(Long id);
    List<PlatoObject> getAll(int page, int size, PlatoCategoriaEnum categoria);
    void deleteById(Long id);
}
