package com.example.demo.controleur;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entite.Formation;
import com.example.demo.service.FormationService;

@RestController
@RequestMapping("/formation")
public class FormationControleur {
    private final FormationService formationService;
    public FormationControleur(FormationService formationService) {
        this.formationService = formationService;
    }

    @PostMapping
    public Formation creer(@RequestBody Formation formation) {
        return formationService.creer(formation);
    }

    @GetMapping
    public List<Formation> Lire() {
        return formationService.Lire();
    }
    
    @PutMapping("/{id}")
    public Formation modifier(@PathVariable int id, @RequestBody Formation formation) {
        return formationService.modifier(id, formation);
    }

    @DeleteMapping("/{id}")
    public String supprimer(@PathVariable int id) {
        return formationService.supprimer(id);
    }

    @PutMapping("/{formationId}/affecter-formateur/{formateurId}")
    public ResponseEntity<String> affecterFormateur(
            @PathVariable int formationId,
            @PathVariable int formateurId
    ) {
        boolean affectationReussie = formationService.affecterFormateur(formationId, formateurId);

        if (affectationReussie) {
            return ResponseEntity.ok("Formateur affecté avec succès à la formation.");
        } else {
            return ResponseEntity.badRequest().body("Formation ou formateur non trouvé.");
        }
    }
}
