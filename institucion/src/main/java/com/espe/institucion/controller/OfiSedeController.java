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

import com.espe.institucion.model.OfiSede;
import com.espe.institucion.repository.OfiSedeRepository;

@RestController
@RequestMapping("/api/sedes")
public class OfiSedeController {

    @Autowired
    private OfiSedeRepository repository;

    @GetMapping
    public List<OfiSede> getAllSedes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfiSede> getSedeById(@PathVariable String id) {
        Optional<OfiSede> sede = repository.findById(id);
        if (sede.isPresent()) {
            return ResponseEntity.ok(sede.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public OfiSede createSede(@RequestBody OfiSede sede) {
        return repository.save(sede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfiSede> updateSede(@PathVariable String id, @RequestBody OfiSede sedeDetails) {
        Optional<OfiSede> sede = repository.findById(id);
        if (sede.isPresent()) {
            sedeDetails.setCodSede(id);
            return ResponseEntity.ok(repository.save(sedeDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSede(@PathVariable String id) {
        Optional<OfiSede> sede = repository.findById(id);
        if (sede.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}