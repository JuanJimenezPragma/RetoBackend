package com.pragma.retobackend.retobackend.infrastructure.configuration;

import com.pragma.retobackend.retobackend.domain.api.ICuentaServicePort;
import com.pragma.retobackend.retobackend.domain.api.IPedidoServicePort;
import com.pragma.retobackend.retobackend.domain.api.IPlatoServicePort;
import com.pragma.retobackend.retobackend.domain.api.IRestauranteServicePort;
import com.pragma.retobackend.retobackend.domain.spi.ICuentaPersistencePort;
import com.pragma.retobackend.retobackend.domain.spi.IPedidoPersistencePort;
import com.pragma.retobackend.retobackend.domain.spi.IPlatoPersistencePort;
import com.pragma.retobackend.retobackend.domain.spi.IRestaurantePersistencePort;
import com.pragma.retobackend.retobackend.domain.usecase.CuentaUseCase;
import com.pragma.retobackend.retobackend.domain.usecase.PedidoUseCase;
import com.pragma.retobackend.retobackend.domain.usecase.PlatoUseCase;
import com.pragma.retobackend.retobackend.domain.usecase.RestauranteUseCase;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.adapter.CuentaJpaAdapter;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.adapter.PedidoJpaAdapter;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.adapter.PlatoJpaAdapter;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.adapter.RestauranteJpaAdapter;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.ICuentaEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.IPedidoEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.IPlatoEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository.ICuentaRepository;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository.IPedidoRepository;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository.IPlatoRepository;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICuentaRepository cuentaRepository;
    private final ICuentaEntityMapper cuentaEntityMapper;
    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;
    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    private final IPedidoRepository pedidoRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;

    @Bean
    public ICuentaPersistencePort cuentaPersistencePort() {
        return new CuentaJpaAdapter(cuentaRepository, cuentaEntityMapper);
    }

    @Bean
    public ICuentaServicePort cuentaServicePort() {
        return new CuentaUseCase(cuentaPersistencePort());
    }

    @Bean
    public IRestaurantePersistencePort restaurantePersistencePort() {
        return new RestauranteJpaAdapter(restauranteRepository, restauranteEntityMapper);
    }

    @Bean
    public IRestauranteServicePort restauranteServicePort() {
        return new RestauranteUseCase(restaurantePersistencePort());
    }

    @Bean
    public IPlatoPersistencePort platoPersistencePort() {
        return new PlatoJpaAdapter(platoRepository, platoEntityMapper);
    }

    @Bean
    public IPlatoServicePort platoServicePort() {
        return new PlatoUseCase(platoPersistencePort(), cuentaPersistencePort());
    }

    @Bean
    public IPedidoPersistencePort pedidoPersistencePort() {
        return new PedidoJpaAdapter(pedidoRepository, pedidoEntityMapper, cuentaEntityMapper, restauranteEntityMapper);
    }

    @Bean
    public IPedidoServicePort pedidoServicePort() {
        return new PedidoUseCase(pedidoPersistencePort(), cuentaPersistencePort());
    }

}
