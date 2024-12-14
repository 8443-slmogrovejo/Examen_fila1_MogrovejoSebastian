package com.espe.edificio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espe.edificio.model.AulaPK;
import com.espe.edificio.model.OfiAula;

public interface OfiAulaRepository extends JpaRepository<OfiAula, AulaPK>{

}
