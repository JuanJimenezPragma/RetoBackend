package com.pragma.retobackend.retobackend.domain.api;

import com.pragma.retobackend.retobackend.domain.enums.PlatoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import com.pragma.retobackend.retobackend.domain.model.PlatoObject;

import java.util.List;

public interface IPlatoServicePort {
    void save(PlatoObject plato, String usuario);
    PlatoObject update(Long id, PlatoObject plato, String usuario);
    List<PlatoObject> getAll(int page, int size, PlatoCategoriaEnum categoria);
    void deleteById(Long id);
    void changueStatus(Long idplato, PlatoEstadoEnum estado, String usuario);
}
