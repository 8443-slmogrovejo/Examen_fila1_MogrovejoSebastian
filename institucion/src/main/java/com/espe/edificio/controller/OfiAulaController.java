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
import org.springframework.web.bind.annotation.RestController;

import com.espe.edificio.model.AulaPK;
import com.espe.edificio.model.OfiAula;
import com.espe.edificio.repository.OfiAulaRepository;

@RestController
@RequestMapping("/api/aulas")
public class OfiAulaController {

    @Autowired
    private OfiAulaRepository repository;

    @GetMapping
    public List<OfiAula> getAllAulas() {
        return repository.findAll();
    }

    @GetMapping("/{codAula}/{codEdificio}/{codEdificioBloque}")
    public ResponseEntity<OfiAula> getAulaById(@PathVariable Integer codAula, @PathVariable String codEdificio,
            @PathVariable String codEdificioBloque) {
        AulaPK pk = new AulaPK(codAula, codEdificio, codEdificioBloque);
        Optional<OfiAula> aula = repository.findById(pk);
        if (aula.isPresent()) {
            return ResponseEntity.ok(aula.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public OfiAula createAula(@RequestBody OfiAula aula) {
        return repository.save(aula);
    }

    @PutMapping("/{codAula}/{codEdificio}/{codEdificioBloque}")
    public ResponseEntity<OfiAula> updateAula(@PathVariable Integer codAula, @PathVariable String codEdificio,
            @PathVariable String codEdificioBloque, @RequestBody OfiAula aulaDetails) {
        AulaPK pk = new AulaPK(codAula, codEdificio, codEdificioBloque);
        Optional<OfiAula> aula = repository.findById(pk);
        if (aula.isPresent()) {
            aulaDetails.setPk(pk);
            return ResponseEntity.ok(repository.save(aulaDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codAula}/{codEdificio}/{codEdificioBloque}")
    public ResponseEntity<Void> deleteAula(@PathVariable Integer codAula, @PathVariable String codEdificio,
            @PathVariable String codEdificioBloque) {
        AulaPK pk = new AulaPK(codAula, codEdificio, codEdificioBloque);
        Optional<OfiAula> aula = repository.findById(pk);
        if (aula.isPresent()) {
            repository.deleteById(pk);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}