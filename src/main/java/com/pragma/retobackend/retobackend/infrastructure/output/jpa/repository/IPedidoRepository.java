package com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository;

import com.pragma.retobackend.retobackend.domain.enums.PedidoEstadoEnum;
import com.pragma.retobackend.retobackend.domain.model.RestauranteObject;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.CuentaEntity;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.PedidoEntity;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.RestauranteEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPedidoRepository extends JpaRepository<PedidoEntity,Long> {
    List<PedidoEntity> findByEstadoAndRestaurante(PedidoEstadoEnum estado, Pageable pageable, RestauranteEntity restaurante);
    List<PedidoEntity> findByEstadoAndRestauranteAndCliente(PedidoEstadoEnum estado, Pageable pageable, RestauranteObject restaurante, CuentaEntity cliente);
}
