package com.pragma.retobackend.retobackend.application.handler;

import com.pragma.retobackend.retobackend.application.dto.request.PlatoRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.PlatoResponseDto;
import com.pragma.retobackend.retobackend.application.mapper.IPlatoRequestMapper;
import com.pragma.retobackend.retobackend.application.mapper.IPlatoResponseMapper;
import com.pragma.retobackend.retobackend.domain.api.ICuentaServicePort;
import com.pragma.retobackend.retobackend.domain.api.IPlatoServicePort;
import com.pragma.retobackend.retobackend.domain.api.IRestauranteServicePort;
import com.pragma.retobackend.retobackend.domain.enums.PlatoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlatoHandler implements IPlatoHandler{

    private final IPlatoServicePort platoServicePort;
    private final IPlatoRequestMapper platoRequestMapper;
    private final IPlatoResponseMapper platoResponseMapper;
    private final IRestauranteServicePort restauranteServicePort;
    private final ICuentaServicePort cuentaServicePort;

    @Override
    public void save(PlatoRequestDto plato, String usuario) {
        CuentaObject cuenta = cuentaServicePort.getCuentaByEmail(usuario);
        plato.setRestaurante(cuenta.getRestaurante());
        platoServicePort.save(platoRequestMapper.toPlato(plato), usuario);
    }

    @Override
    public PlatoResponseDto update(Long id, PlatoRequestDto plato, String usuario) {
        return platoResponseMapper.toResponse(platoServicePort.update(id, platoRequestMapper.toPlato(plato), usuario));
    }

    @Override
    public List<PlatoResponseDto> getAll(int page, int size, PlatoCategoriaEnum categoria) {

        return platoResponseMapper.toResponseList(platoServicePort.getAll(page,size,categoria));
    }

    @Override
    public void deleteById(Long id) {
        platoServicePort.deleteById(id);
    }

    @Override
    public void changueStatus(Long idPlato, PlatoEstadoEnum estado, String usuario) {
        platoServicePort.changueStatus(idPlato,estado, usuario);
    }
}
