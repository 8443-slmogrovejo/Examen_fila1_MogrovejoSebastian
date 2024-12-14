package com.espe.edificio.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.espe.edificio.model.OfiEdificio;
import com.espe.edificio.repository.OfiEdificioRepository;
import com.espe.edificio.services.OfiEdificioService;

@RestController
@RequestMapping("/api/edificios")
public class OfiEdificioController {

    @Autowired
    private OfiEdificioService edificioService;

    @Autowired
    private OfiEdificioRepository repository;

    @GetMapping("/capacidad-total")
    public ResponseEntity<Integer> getTotalCapacity(@RequestParam String codSede, @RequestParam String codEdificio) {
        int totalCapacity = edificioService.getTotalCapacity(codSede, codEdificio);
        return ResponseEntity.ok(totalCapacity);
    }

    @GetMapping
    public List<OfiEdificio> getAllEdificios() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfiEdificio> getEdificioById(@PathVariable String id) {
        Optional<OfiEdificio> edificio = repository.findById(id);
        if (edificio.isPresent()) {
            return ResponseEntity.ok(edificio.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public OfiEdificio createEdificio(@RequestBody OfiEdificio edificio) {
        return repository.save(edificio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfiEdificio> updateEdificio(@PathVariable String id, @RequestBody OfiEdificio edificioDetails) {
        Optional<OfiEdificio> edificio = repository.findById(id);
        if (edificio.isPresent()) {
            edificioDetails.setCodEdificio(id);
            return ResponseEntity.ok(repository.save(edificioDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEdificio(@PathVariable String id) {
        Optional<OfiEdificio> edificio = repository.findById(id);
        if (edificio.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}