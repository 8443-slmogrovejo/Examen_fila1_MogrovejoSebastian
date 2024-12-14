package com.espe.edificio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espe.edificio.model.OfiAula;
import com.espe.edificio.repository.OfiAulaRepository;

@Service
public class OfiEdificioService {

    @Autowired
    private OfiAulaRepository aulaRepository;

    public int getTotalCapacity(String codSede, String codEdificio) {
        List<OfiAula> aulas = aulaRepository.findByCodEdificioAndCodSede(codEdificio, codSede);
        return aulas.stream().mapToInt(OfiAula::getCapacidad).sum();
    }
}