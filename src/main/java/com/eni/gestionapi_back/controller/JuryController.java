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
import com.eni.gestionapi_back.model.Jury;
import com.eni.gestionapi_back.repository.JuryRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class JuryController {
    @Autowired
    private JuryRepository juryRepository;

    @GetMapping("/jurys")
    public List<Jury> getAllJurys() {
        return juryRepository.findAll();
    }

    @GetMapping("/jurys/{id_jury}")
    public ResponseEntity<Jury> getJuryById(@PathVariable(value = "id_jury") Long juryId)
        throws ResourceNotFoundException {
        Jury jury = juryRepository.findById(juryId)
          .orElseThrow(() -> new ResourceNotFoundException("Jury not found for this id_jury :: " + juryId));
        return ResponseEntity.ok().body(jury);
    }
    
    @PostMapping("/jurys")
    public Jury createJury(@Valid @RequestBody Jury jury) {
        return juryRepository.save(jury);
    }

    @PutMapping("/jurys/{id_jury}")
    public ResponseEntity<Jury> updateJury(@PathVariable(value = "id_jury") Long juryId,
         @Valid @RequestBody Jury juryDetails) throws ResourceNotFoundException {
        Jury jury = juryRepository.findById(juryId)
        .orElseThrow(() -> new ResourceNotFoundException("Jury not found for this id_jury :: " + juryId));

        jury.setJury_nom(juryDetails.getJury_nom());
        jury.setJury_prenom(juryDetails.getJury_prenom());
        jury.setJury_role(juryDetails.getJury_role());
        final Jury updatedJury = juryRepository.save(jury);
        return ResponseEntity.ok(updatedJury);
    }

    @DeleteMapping("/jurys/{id_jury}")
    public Map<String, Boolean> deleteJury(@PathVariable(value = "id_jury") Long juryId)
         throws ResourceNotFoundException {
        Jury jury = juryRepository.findById(juryId)
       .orElseThrow(() -> new ResourceNotFoundException("Jury not found for this id_jury :: " + juryId));

        juryRepository.delete(jury);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
