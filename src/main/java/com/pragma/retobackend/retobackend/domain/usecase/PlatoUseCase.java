package com.pragma.retobackend.retobackend.domain.usecase;

import com.pragma.retobackend.retobackend.domain.api.IPlatoServicePort;
import com.pragma.retobackend.retobackend.domain.enums.PlatoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import com.pragma.retobackend.retobackend.domain.exception.DomainException;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.domain.model.PlatoObject;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import com.pragma.retobackend.retobackend.domain.spi.ICuentaPersistencePort;
import com.pragma.retobackend.retobackend.domain.spi.IPlatoPersistencePort;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class PlatoUseCase implements IPlatoServicePort {

    private final IPlatoPersistencePort platoPersistencePort;
    private final ICuentaPersistencePort cuentaPersistencePort;

    public PlatoUseCase(IPlatoPersistencePort platoPersistencePort, ICuentaPersistencePort cuentaPersistencePort) {
        this.platoPersistencePort = platoPersistencePort;
        this.cuentaPersistencePort = cuentaPersistencePort;
    }

    @Override
    public void save(PlatoObject plato, String usuario) {
        validaRestaurante(plato.getRestaurante(), usuario);
        validaPrecio(plato.getPrecio());
        plato.setEstado(PlatoEstadoEnum.ACTIVO);
        platoPersistencePort.save(plato);
    }

    @Override
    public PlatoObject update(Long id, PlatoObject plato, String usuario) {
        validaPrecio(plato.getPrecio());
        PlatoObject updatePlato = platoPersistencePort.getById(id);
        validaRestaurante(updatePlato.getRestaurante(),usuario);
        updatePlato.setPrecio(plato.getPrecio());
        updatePlato.setDescripcion(plato.getDescripcion());
        return platoPersistencePort.update(updatePlato);
    }

    @Override
    public List<PlatoObject> getAll(int page, int size, PlatoCategoriaEnum categoria) {

        return platoPersistencePort.getAll(page,size,categoria);
    }

    @Override
    public void deleteById(Long id) {
        platoPersistencePort.deleteById(id);
    }

    @Override
    public void changueStatus(Long idplato, PlatoEstadoEnum estado, String usuario) {
        PlatoObject plato = platoPersistencePort.getById(idplato);
        validaRestaurante(plato.getRestaurante(), usuario);
        plato.setEstado(estado);
        platoPersistencePort.save(plato);
    }

    public void validaRestaurante(RestauranteObject restaurante, String usuario){
        if(restaurante == null){
            throw new DomainException("No existe restaurante.");
        }
        CuentaObject cuenta = cuentaPersistencePort.getCuentaByEmail(usuario);
        if (!Objects.equals(restaurante.getId(), cuenta.getRestaurante().getId())){
            throw new DomainException("No eres propietario del restaurante para este plato.");
        }
    }

    public void validaPrecio(BigDecimal precio){
        if (precio.compareTo(BigDecimal.ZERO) == 0 || precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainException("El valor del plato no puede ser menor o igual a 0");
        }
    }
}
