package com.example.demo.controleur;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entite.Formation;
import com.example.demo.service.FormationService;

//Pour texter api a postman le voila url : http://localhost:8080/api/formateur/
@RestController
@RequestMapping("/formation")
public class FormationControleur {
    private final FormationService formationService;

    public FormationControleur(FormationService formationService) {
        this.formationService = formationService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Formation creer(@RequestBody Formation formation) {
        return formationService.creer(formation);
    }

    @GetMapping
    public List<Formation> rechercher(@RequestParam(required = false)  String nom) {
        return formationService.rechercher(nom);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Formation modifier(@PathVariable int id, @RequestBody Formation formation) {
        return formationService.modifier(id, formation);
    }

    @DeleteMapping("/{id}")
    public String supprimer(@PathVariable int id) {
        return formationService.supprimer(id);
    }

    // ResponseEntity<String> est une classe Spring Framework utilisée pour
    // représenter une réponse HTTP qui renvoie un corps de texte (String)
    // pour tester cette methode le voila url :
    // http://localhost:8080/api/formation/3/affecter-formateur/3
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{formationId}/affecter-formateur/{formateurId}")
    public ResponseEntity<String> affecterFormateur(
            @PathVariable int formationId,
            @PathVariable int formateurId) {
        boolean affectationReussie = formationService.affecterFormateur(formationId, formateurId);

        if (affectationReussie) {
            return ResponseEntity.ok("Formateur affecté avec succès à la formation.");
        } else {
            return ResponseEntity.badRequest().body("Formation ou formateur non trouvé.");
        }
    }
}
