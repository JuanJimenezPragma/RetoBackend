package com.pragma.retobackend.retobackend.domain.usecase;

import com.pragma.retobackend.retobackend.domain.api.IRestauranteServicePort;
import com.pragma.retobackend.retobackend.domain.exception.DomainException;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import com.pragma.retobackend.retobackend.domain.spi.IRestaurantePersistencePort;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class RestauranteUseCase implements IRestauranteServicePort {

    private final IRestaurantePersistencePort restaurantePersistencePort;

    private static final String PHONE_REGEX = "^\\+?[0-9]{1,13}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    public RestauranteUseCase(IRestaurantePersistencePort restaurantePersistencePort){
        this.restaurantePersistencePort = restaurantePersistencePort;
    }

    @Override
    public void save(RestauranteObject restaurante) {
        validarTelefono(restaurante.getTelefono());
        restaurantePersistencePort.save(restaurante);
    }

    @Override
    public List<RestauranteObject> getAll(int page, int size) {
        return restaurantePersistencePort.getAll(page,size).stream().sorted(Comparator.comparing(RestauranteObject::getNombre)).toList();
    }

    @Override
    public RestauranteObject getRestauranteById(Long id) {
        return restaurantePersistencePort.getRestauranteById(id);
    }

    public void validarTelefono(String telefono) {
        if (telefono == null || !PHONE_PATTERN.matcher(telefono).matches()) {
            throw new DomainException("El teléfono '" + telefono + "' no es válido. Debe contener máximo 13 caracteres y solo puede incluir números y el símbolo '+'.");
        }
    }


}
