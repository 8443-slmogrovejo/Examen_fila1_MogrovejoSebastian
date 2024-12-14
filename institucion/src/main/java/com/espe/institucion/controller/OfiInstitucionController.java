package com.espe.institucion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espe.institucion.model.OfiInstitucion;
import com.espe.institucion.services.OfiInstitucionService;

@RestController
@RequestMapping("/api/instituciones")
public class OfiInstitucionController {

    @Autowired
    private OfiInstitucionService service;

    @GetMapping
    public List<OfiInstitucion> getAllInstituciones() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfiInstitucion> getInstitucionById(@PathVariable Integer id) {
        Optional<OfiInstitucion> institucion = service.findById(id);
        if (institucion.isPresent()) {
            return ResponseEntity.ok(institucion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public OfiInstitucion createInstitucion(@RequestBody OfiInstitucion institucion) {
        return service.save(institucion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfiInstitucion> updateInstitucion(@PathVariable Integer id, @RequestBody OfiInstitucion institucionDetails) {
        Optional<OfiInstitucion> institucion = service.findById(id);
        if (institucion.isPresent()) {
            institucionDetails.setCodInstitucion(id);
            return ResponseEntity.ok(service.update(institucionDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitucion(@PathVariable Integer id) {
        Optional<OfiInstitucion> institucion = service.findById(id);
        if (institucion.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}