package com.espe.edificio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.espe.edificio.model.AulaPK;
import com.espe.edificio.model.OfiAula;

public interface OfiAulaRepository extends JpaRepository<OfiAula, AulaPK> {

    @Query("SELECT a FROM OfiAula a WHERE a.pk.codEdificio = :codEdificio AND a.pk.codSede = :codSede")
    List<OfiAula> findByCodEdificioAndCodSede(@Param("codEdificio") String codEdificio, @Param("codSede") String codSede);
}