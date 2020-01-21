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
import com.eni.gestionapi_back.model.Annee;
import com.eni.gestionapi_back.repository.AnneeRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AnneeController {
    @Autowired
    private AnneeRepository anneeRepository;

    @GetMapping("/annees")
    public List<Annee> getAllAnnees() {
        return anneeRepository.findAll();
    }

    @GetMapping("/annees/{id_annee}")
    public ResponseEntity<Annee> getAnneeById(@PathVariable(value = "id_annee") Long anneeId)
        throws ResourceNotFoundException {
        Annee annee = anneeRepository.findById(anneeId)
          .orElseThrow(() -> new ResourceNotFoundException("Annee not found for this id_annee :: " + anneeId));
        return ResponseEntity.ok().body(annee);
    }
    
    @PostMapping("/annees")
    public Annee createAnnee(@Valid @RequestBody Annee annee) {
        return anneeRepository.save(annee);
    }

    @PutMapping("/annees/{id_annee}")
    public ResponseEntity<Annee> updateAnnee(@PathVariable(value = "id_annee") Long anneeId,
         @Valid @RequestBody Annee anneeDetails) throws ResourceNotFoundException {
        Annee annee = anneeRepository.findById(anneeId)
        .orElseThrow(() -> new ResourceNotFoundException("Annee not found for this id_annee :: " + anneeId));

        annee.setAnnee_univ(anneeDetails.getAnnee_univ());
        final Annee updatedAnnee = anneeRepository.save(annee);
        return ResponseEntity.ok(updatedAnnee);
    }

    @DeleteMapping("/annees/{id_annee}")
    public Map<String, Boolean> deleteAnnee(@PathVariable(value = "id_annee") Long anneeId)
         throws ResourceNotFoundException {
        Annee annee = anneeRepository.findById(anneeId)
       .orElseThrow(() -> new ResourceNotFoundException("Annee not found for this id_annee :: " + anneeId));

        anneeRepository.delete(annee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
