package com.example.demo.service;

import com.example.demo.entite.Formation;

import java.util.List;

public interface FormationService {
    Formation creer(Formation formation);
    List<Formation> Lire();
    Formation modifier(int id, Formation formation);
    String supprimer(int id);
}
