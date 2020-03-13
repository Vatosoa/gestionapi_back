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
import com.eni.gestionapi_back.model.Service;
import com.eni.gestionapi_back.repository.ServiceRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/services")
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/services/{id_service}")
    public ResponseEntity<Service> getServiceById(@PathVariable(value = "id_service") Long serviceId)
        throws ResourceNotFoundException {
    	Service service = serviceRepository.findById(serviceId)
          .orElseThrow(() -> new ResourceNotFoundException("Jury not found for this id_jury :: " + serviceId));
        return ResponseEntity.ok().body(service);
    }
    
    @PostMapping("/services")
    public Service createService(@Valid @RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @PutMapping("/services/{id_service}")
    public ResponseEntity<Service> updateService(@PathVariable(value = "id_service") Long serviceId,
         @Valid @RequestBody Service serviceDetails) throws ResourceNotFoundException {
    	Service service = serviceRepository.findById(serviceId)
        .orElseThrow(() -> new ResourceNotFoundException("Service not found for this id_service :: " + serviceId));

    	service.setService_nom(serviceDetails.getService_nom());
    	service.setService_prenom(serviceDetails.getService_prenom());
    	service.setService_sexe(serviceDetails.getService_sexe());
    	service.setService_resp(serviceDetails.getService_resp());
    	service.setService_adr(serviceDetails.getService_adr());
    	service.setService_email(serviceDetails.getService_email());
    	service.setService_tel(serviceDetails.getService_tel());
        final Service updatedService = serviceRepository.save(service);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/services/{id_service}")
    public Map<String, Boolean> deleteJury(@PathVariable(value = "id_service") Long serviceId)
         throws ResourceNotFoundException {
        Service service = serviceRepository.findById(serviceId)
       .orElseThrow(() -> new ResourceNotFoundException("Service not found for this id_service :: " + serviceId));

        serviceRepository.delete(service);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
