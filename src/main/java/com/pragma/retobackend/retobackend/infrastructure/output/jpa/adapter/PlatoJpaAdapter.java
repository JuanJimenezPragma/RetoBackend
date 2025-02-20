package com.pragma.retobackend.retobackend.infrastructure.output.jpa.adapter;

import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import com.pragma.retobackend.retobackend.domain.model.PlatoObject;
import com.pragma.retobackend.retobackend.domain.spi.IPlatoPersistencePort;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.IPlatoEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository.IPlatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class PlatoJpaAdapter implements IPlatoPersistencePort {

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;

    @Override
    public void save(PlatoObject plato) {
        platoRepository.save(platoEntityMapper.toEntity(plato));
    }

    @Override
    public PlatoObject update(PlatoObject plato) {
        return platoEntityMapper.toModel(platoRepository.save(platoEntityMapper.toEntity(plato)));
    }

    @Override
    public PlatoObject getById(Long id) {
        return platoEntityMapper.toModel(platoRepository.findById(id).orElse(null));
    }

    @Override
    public List<PlatoObject> getAll(int page, int size, PlatoCategoriaEnum categoria) {
        Pageable pageable = PageRequest.of(page,size);
        return platoEntityMapper.toPlatoModelList(platoRepository.findByCategoria(categoria,pageable).stream().toList());
    }

    @Override
    public void deleteById(Long id) {
        platoRepository.deleteById(id);
    }
}
