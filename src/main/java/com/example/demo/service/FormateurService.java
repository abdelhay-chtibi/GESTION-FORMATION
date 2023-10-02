package com.example.demo.service;

import com.example.demo.entite.Formateur;

import java.util.List;

public interface FormateurService {
    Formateur creer(Formateur formateur);

    List<Formateur> Lire();

    Formateur modifier(int id, Formateur formateur);
    
    String supprimer(int id);
}
