package com.eni.gestionapi_back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eni.gestionapi_back.exception.ResourceNotFoundException;
import com.eni.gestionapi_back.model.Niveau;
import com.eni.gestionapi_back.repository.NiveauRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class NiveauController {
    @Autowired
    private NiveauRepository niveauRepository;

    @GetMapping("/niveaux")
    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    @GetMapping("/niveaux/{id_niveau}")
    public ResponseEntity<Niveau> getNiveauById(@PathVariable(value = "id_niveau") Long niveauId)
        throws ResourceNotFoundException {
        Niveau niveau = niveauRepository.findById(niveauId)
          .orElseThrow(() -> new ResourceNotFoundException("Niveau not found for this id_niveau :: " + niveauId));
        return ResponseEntity.ok().body(niveau);
    }
    
    @PostMapping("/niveaux")
    public Niveau createNiveau(@Valid @RequestBody Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @PutMapping("/niveaux/{id_niveau}")
    public ResponseEntity<Niveau> updateNiveau(@PathVariable(value = "id_niveau") Long niveauId,
         @Valid @RequestBody Niveau niveauDetails) throws ResourceNotFoundException {
        Niveau niveau = niveauRepository.findById(niveauId)
        .orElseThrow(() -> new ResourceNotFoundException("Niveau not found for this id_niveau :: " + niveauId));

        niveau.setNiveau_nom(niveauDetails.getNiveau_nom());
        final Niveau updatedNiveau = niveauRepository.save(niveau);
        return ResponseEntity.ok(updatedNiveau);
    }

    @DeleteMapping("/niveaux/{id_niveau}")
    public Map<String, Boolean> deleteNiveau(@PathVariable(value = "id_niveau") Long niveauId)
         throws ResourceNotFoundException {
        Niveau niveau = niveauRepository.findById(niveauId)
       .orElseThrow(() -> new ResourceNotFoundException("Niveau not found for this id_niveau :: " + niveauId));

        niveauRepository.delete(niveau);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
