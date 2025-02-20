package com.pragma.retobackend.retobackend.application.handler;

import com.pragma.retobackend.retobackend.application.dto.request.PlatoRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.PlatoResponseDto;
import com.pragma.retobackend.retobackend.domain.enums.PlatoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;

import java.util.List;

public interface IPlatoHandler {
    void save(PlatoRequestDto plato, String usuario);
    PlatoResponseDto update(Long id, PlatoRequestDto plato, String usuario);
    List<PlatoResponseDto> getAll(int page, int size, PlatoCategoriaEnum categoria);
    void deleteById(Long id);
    void changueStatus(Long idPlato, PlatoEstadoEnum estado, String usuario);
}
