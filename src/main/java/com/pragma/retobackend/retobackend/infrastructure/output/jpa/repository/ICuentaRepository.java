package com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository;

import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICuentaRepository extends JpaRepository<CuentaEntity, Long> {

    Optional<CuentaEntity> findByCorreo(String correo);

}
