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
import com.eni.gestionapi_back.model.Calendrier;
import com.eni.gestionapi_back.repository.CalendrierRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class CalendrierController {
    @Autowired
    private CalendrierRepository calendrierRepository;

    @GetMapping("/calendriers")
    public List<Calendrier> getAllCalendriers() {
        return calendrierRepository.findAll();
    }

    @GetMapping("/calendriers/{id_cal}")
    public ResponseEntity<Calendrier> getCalendrierById(@PathVariable(value = "id_cal") Long calId)
        throws ResourceNotFoundException {
        Calendrier calendrier = calendrierRepository.findById(calId)
          .orElseThrow(() -> new ResourceNotFoundException("Calendrier not found for this id_cal :: " + calId));
        return ResponseEntity.ok().body(calendrier);
    }
    
    @PostMapping("/calendriers")
    public Calendrier createCalendrier(@Valid @RequestBody Calendrier calendrier) {
        return calendrierRepository.save(calendrier);
    }

    @PutMapping("/calendriers/{id_cal}")
    public ResponseEntity<Calendrier> updateCalendrier(@PathVariable(value = "id_cal") Long calId,
         @Valid @RequestBody Calendrier calendrierDetails) throws ResourceNotFoundException {
        Calendrier calendrier = calendrierRepository.findById(calId)
        .orElseThrow(() -> new ResourceNotFoundException("Calendrier not found for this id_cal :: " + calId));

        calendrier.setCal_lieu_stage(calendrierDetails.getCal_lieu_stage());
        calendrier.setCal_type_memoire(calendrierDetails.getCal_type_memoire());
        calendrier.setCal_lieu_sout(calendrierDetails.getCal_lieu_sout());
        calendrier.setCal_date_sout(calendrierDetails.getCal_date_sout());
        calendrier.setCal_heure_sout(calendrierDetails.getCal_heure_sout());
        calendrier.setCal_sale_sout(calendrierDetails.getCal_sale_sout());
        calendrier.setCal_note_sout(calendrierDetails.getCal_note_sout());
        final Calendrier updatedCalendrier = calendrierRepository.save(calendrier);
        return ResponseEntity.ok(updatedCalendrier);
    }

    @DeleteMapping("/calendriers/{id_cal}")
    public Map<String, Boolean> deleteCalendrier(@PathVariable(value = "id_cal") Long calId)
         throws ResourceNotFoundException {
        Calendrier calendrier = calendrierRepository.findById(calId)
       .orElseThrow(() -> new ResourceNotFoundException("Calendrier not found for this id_cal :: " + calId));

        calendrierRepository.delete(calendrier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
