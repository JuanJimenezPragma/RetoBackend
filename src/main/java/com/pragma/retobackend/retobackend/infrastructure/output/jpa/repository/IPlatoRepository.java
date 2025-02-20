package com.pragma.retobackend.retobackend.infrastructure.output.jpa.repository;

import com.pragma.retobackend.retobackend.domain.enums.PlatoCategoriaEnum;
import com.pragma.retobackend.retobackend.infrastructure.output.jpa.entity.PlatoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlatoRepository extends JpaRepository<PlatoEntity, Long> {

    @Query("SELECT p FROM PlatoEntity p WHERE :categoria IS NULL OR p.categoria = :categoria")
    List<PlatoEntity> findByCategoria(@Param("categoria") PlatoCategoriaEnum categoria, Pageable pageable);
}
