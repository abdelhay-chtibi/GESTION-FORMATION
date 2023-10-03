package com.example.demo.service;

import com.example.demo.entite.Formation;

import java.util.List;

public interface FormationService {
    Formation creer(Formation formation);
    List<Formation> rechercher(String nom);
    Formation modifier(int id, Formation formation);
    String supprimer(int id);
    public boolean affecterFormateur(int formationId, int formateurId);
}
