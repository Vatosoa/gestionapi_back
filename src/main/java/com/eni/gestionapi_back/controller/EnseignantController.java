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
import com.eni.gestionapi_back.model.Enseignant;
import com.eni.gestionapi_back.repository.EnseignantRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EnseignantController {
    @Autowired
    private EnseignantRepository enseignantRepository;

    @GetMapping("/enseignants")
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @GetMapping("/enseignants/{id_enseig}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable(value = "id_enseig") Long enseigId)
        throws ResourceNotFoundException {
        Enseignant enseignant = enseignantRepository.findById(enseigId)
          .orElseThrow(() -> new ResourceNotFoundException("Jury not found for this id_jury :: " + enseigId));
        return ResponseEntity.ok().body(enseignant);
    }
    
    @PostMapping("/enseignants")
    public Enseignant createEnseignant(@Valid @RequestBody Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @PutMapping("/enseignants/{id_enseig}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable(value = "id_enseig") Long enseigId,
         @Valid @RequestBody Enseignant enseignantDetails) throws ResourceNotFoundException {
        Enseignant enseignant = enseignantRepository.findById(enseigId)
        .orElseThrow(() -> new ResourceNotFoundException("Enseignant not found for this id_enseig :: " + enseigId));

        enseignant.setEnseig_nom(enseignantDetails.getEnseig_nom());
        enseignant.setEnseig_prenom(enseignantDetails.getEnseig_prenom());
        enseignant.setEnseig_sexe(enseignantDetails.getEnseig_sexe());
        enseignant.setEnseig_grade(enseignantDetails.getEnseig_grade());
        enseignant.setEnseig_adr(enseignantDetails.getEnseig_adr());
        enseignant.setEnseig_email(enseignantDetails.getEnseig_email());
        enseignant.setEnseig_tel(enseignantDetails.getEnseig_tel());
        final Enseignant updatedEnseignant = enseignantRepository.save(enseignant);
        return ResponseEntity.ok(updatedEnseignant);
    }

    @DeleteMapping("/enseignants/{id_enseig}")
    public Map<String, Boolean> deleteEnseignant(@PathVariable(value = "id_enseig") Long enseigId)
         throws ResourceNotFoundException {
        Enseignant enseignant = enseignantRepository.findById(enseigId)
       .orElseThrow(() -> new ResourceNotFoundException("Enseignant not found for this id_enseig :: " + enseigId));

        enseignantRepository.delete(enseignant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
