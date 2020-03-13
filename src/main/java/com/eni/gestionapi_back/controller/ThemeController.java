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
import com.eni.gestionapi_back.model.Theme;
import com.eni.gestionapi_back.repository.ThemeRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ThemeController {
    @Autowired
    private ThemeRepository themeRepository;

    @GetMapping("/themes")
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    @GetMapping("/themes/{id_theme}")
    public ResponseEntity<Theme> getThemeById(@PathVariable(value = "id_theme") Long themeId)
        throws ResourceNotFoundException {
        Theme theme = themeRepository.findById(themeId)
          .orElseThrow(() -> new ResourceNotFoundException("Theme not found for this id_theme :: " + themeId));
        return ResponseEntity.ok().body(theme);
    }
    
    @PostMapping("/themes")
    public Theme createTheme(@Valid @RequestBody Theme theme) {
        return themeRepository.save(theme);
    }

    @PutMapping("/themes/{id_theme}")
    public ResponseEntity<Theme> updateTheme(@PathVariable(value = "id_theme") Long themeId,
         @Valid @RequestBody Theme themeDetails) throws ResourceNotFoundException {
        Theme theme = themeRepository.findById(themeId)
        .orElseThrow(() -> new ResourceNotFoundException("Theme not found for this id_theme :: " + themeId));

        theme.setTheme_nom(themeDetails.getTheme_nom());
        final Theme updatedTheme = themeRepository.save(theme);
        return ResponseEntity.ok(updatedTheme);
    }

    @DeleteMapping("/themes/{id_theme}")
    public Map<String, Boolean> deleteTheme(@PathVariable(value = "id_theme") Long themeId)
         throws ResourceNotFoundException {
        Theme theme = themeRepository.findById(themeId)
       .orElseThrow(() -> new ResourceNotFoundException("Theme not found for this id_theme :: " + themeId));

        themeRepository.delete(theme);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
