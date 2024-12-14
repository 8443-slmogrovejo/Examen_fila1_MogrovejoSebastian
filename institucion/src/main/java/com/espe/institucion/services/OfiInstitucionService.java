package com.espe.institucion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espe.institucion.model.OfiInstitucion;
import com.espe.institucion.repository.OfiInstitucionRepository;

@Service
public class OfiInstitucionService {

    @Autowired
    private OfiInstitucionRepository repository;

    public List<OfiInstitucion> findAll() {
        return repository.findAll();
    }

    public Optional<OfiInstitucion> findById(Integer id) {
        return repository.findById(id);
    }

    public OfiInstitucion save(OfiInstitucion institucion) {
        return repository.save(institucion);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public OfiInstitucion update(OfiInstitucion institucion) {
        return repository.save(institucion);
    }
}