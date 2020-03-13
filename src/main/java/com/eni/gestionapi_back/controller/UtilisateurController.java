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
import com.eni.gestionapi_back.model.Utilisateur;
import com.eni.gestionapi_back.repository.UtilisateurRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @GetMapping("/utilisateurs/{id_login}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value = "id_login") Long loginId)
        throws ResourceNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findById(loginId)
          .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id_login :: " + loginId));
        return ResponseEntity.ok().body(utilisateur);
    }
    
    @PostMapping("/utilisateurs")
    public Utilisateur createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @PutMapping("/utilisateurs/{id_login}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id_login") Long loginId,
         @Valid @RequestBody Utilisateur utilisateurDetails) throws ResourceNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findById(loginId)
        .orElseThrow(() -> new ResourceNotFoundException("Jury not found for this id_login :: " + loginId));

        utilisateur.setLogin(utilisateurDetails.getLogin());
        utilisateur.setPassword(utilisateurDetails.getPassword());
        final Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
        return ResponseEntity.ok(updatedUtilisateur);
    }

    @DeleteMapping("/utilisateurs/{id_login}")
    public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id_login") Long loginId)
         throws ResourceNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findById(loginId)
       .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id_login :: " + loginId));

        utilisateurRepository.delete(utilisateur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

