package com.example.demo.controleur;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entite.Formateur;
import com.example.demo.service.FormateurService;

@RestController
@RequestMapping("formateur")
public class FormateurControleur {
    private final FormateurService formateurService;

    public FormateurControleur(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Formateur creer(@RequestBody Formateur formateur) {
        return formateurService.creer(formateur);
    }

    @GetMapping
    public List<Formateur> Lire() {
        return formateurService.Lire();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Formateur modifier(@PathVariable int id, @RequestBody Formateur formateur) {
        return formateurService.modifier(id, formateur);
    }

    @DeleteMapping("/{id}")
    public String supprimer(@PathVariable int id) {
        return formateurService.supprimer(id);
    }
}
