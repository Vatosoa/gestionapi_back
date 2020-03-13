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
import com.eni.gestionapi_back.model.Etablissement;
import com.eni.gestionapi_back.repository.EtablissementRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EtablissementController {
    @Autowired
    private EtablissementRepository etablissementRepository;

    @GetMapping("/etablissements")
    public List<Etablissement> getAllEtablissements() {
        return etablissementRepository.findAll();
    }

    @GetMapping("/etablissements/{id_etabli}")
    public ResponseEntity<Etablissement> getEtablissementById(@PathVariable(value = "id_etabli") Long etabliId)
        throws ResourceNotFoundException {
    	Etablissement etablissement = etablissementRepository.findById(etabliId)
          .orElseThrow(() -> new ResourceNotFoundException("Jury not found for this id_jury :: " + etabliId));
        return ResponseEntity.ok().body(etablissement);
    }
    
    @PostMapping("/etablissements")
    public Etablissement createEtablissement(@Valid @RequestBody Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    @PutMapping("/etablissements/{id_etabli}")
    public ResponseEntity<Etablissement> updateEtablissement(@PathVariable(value = "id_etabli") Long etabliId,
         @Valid @RequestBody Etablissement etablissementDetails) throws ResourceNotFoundException {
    	Etablissement etablissement = etablissementRepository.findById(etabliId)
        .orElseThrow(() -> new ResourceNotFoundException("Etablissement not found for this id_etabli :: " + etabliId));

    	etablissement.setEtabli_nom(etablissementDetails.getEtabli_nom());
    	etablissement.setEtabli_adr(etablissementDetails.getEtabli_adr());
    	etablissement.setEtabli_code_post(etablissementDetails.getEtabli_code_post());
        final Etablissement updatedEtablissement = etablissementRepository.save(etablissement);
        return ResponseEntity.ok(updatedEtablissement);
    }

    @DeleteMapping("/etablissements/{id_etabli}")
    public Map<String, Boolean> deleteEtablissement(@PathVariable(value = "id_etabli") Long etabliId)
         throws ResourceNotFoundException {
    	Etablissement etablissement = etablissementRepository.findById(etabliId)
       .orElseThrow(() -> new ResourceNotFoundException("Etablissement not found for this id_etabli :: " + etabliId));

    	etablissementRepository.delete(etablissement);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
