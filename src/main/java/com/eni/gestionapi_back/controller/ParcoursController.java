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
import com.eni.gestionapi_back.model.Parcours;
import com.eni.gestionapi_back.repository.ParcoursRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ParcoursController {
    @Autowired
    private ParcoursRepository parcoursRepository;

    @GetMapping("/parcours")
    public List<Parcours> getAllParcours() {
        return parcoursRepository.findAll();
    }

    @GetMapping("/parcours/{id_parcours}")
    public ResponseEntity<Parcours> getParcoursById(@PathVariable(value = "id_parcours") Long parcoursId)
        throws ResourceNotFoundException {
        Parcours parcours = parcoursRepository.findById(parcoursId)
          .orElseThrow(() -> new ResourceNotFoundException("Parcours not found for this id_parcours :: " + parcoursId));
        return ResponseEntity.ok().body(parcours);
    }
    
    @PostMapping("/parcours")
    public Parcours createParcours(@Valid @RequestBody Parcours parcours) {
        return parcoursRepository.save(parcours);
    }

    @PutMapping("/parcours/{id_parcours}")
    public ResponseEntity<Parcours> updateParcours(@PathVariable(value = "id_parcours") Long parcoursId,
         @Valid @RequestBody Parcours parcoursDetails) throws ResourceNotFoundException {
        Parcours parcours = parcoursRepository.findById(parcoursId)
        .orElseThrow(() -> new ResourceNotFoundException("Parcours not found for this id_parcours :: " + parcoursId));

        parcours.setParcours_nom(parcoursDetails.getParcours_nom());
        final Parcours updatedParcours = parcoursRepository.save(parcours);
        return ResponseEntity.ok(updatedParcours);
    }

    @DeleteMapping("/parcours/{id_parcours}")
    public Map<String, Boolean> deleteParcours(@PathVariable(value = "id_parcours") Long parcoursId)
         throws ResourceNotFoundException {
        Parcours parcours = parcoursRepository.findById(parcoursId)
       .orElseThrow(() -> new ResourceNotFoundException("Parcours not found for this id_parcours:: " + parcoursId));

        parcoursRepository.delete(parcours);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
