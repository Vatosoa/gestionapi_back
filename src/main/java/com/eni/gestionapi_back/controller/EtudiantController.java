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
import com.eni.gestionapi_back.model.Etudiant;
import com.eni.gestionapi_back.repository.EtudiantRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @GetMapping("/etudiants/{id_etud}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable(value = "id_etud") Long etudId)
        throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudId)
          .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id_etud :: " + etudId));
        return ResponseEntity.ok().body(etudiant);
    }
    
    @PostMapping("/etudiants")
    public Etudiant createEtudiant(@Valid @RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @PutMapping("/etudiants/{id_etud}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable(value = "id_etud") Long etudId,
         @Valid @RequestBody Etudiant etudiantDetails) throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudId)
        .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id_etud :: " + etudId));

        etudiant.setEtud_num(etudiantDetails.getEtud_num());
        etudiant.setEtud_matricule(etudiantDetails.getEtud_matricule());
        etudiant.setEtud_nom(etudiantDetails.getEtud_nom());
        etudiant.setEtud_prenom(etudiantDetails.getEtud_prenom());
        etudiant.setEtud_sexe(etudiantDetails.getEtud_sexe());
        etudiant.setEtud_adr(etudiantDetails.getEtud_adr());
        etudiant.setEtud_email(etudiantDetails.getEtud_email());
        etudiant.setEtud_tel(etudiantDetails.getEtud_tel());
        final Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }

    @DeleteMapping("/etudiants/{id_etud}")
    public Map<String, Boolean> deleteEtudiant(@PathVariable(value = "id_etud") Long etudId)
         throws ResourceNotFoundException {
    	Etudiant etudiant = etudiantRepository.findById(etudId)
       .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id_etud :: " + etudId));

    	etudiantRepository.delete(etudiant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
