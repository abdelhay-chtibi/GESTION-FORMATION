package com.example.demo.service;


import com.example.demo.entite.Formateur;
import com.example.demo.entite.Formation;
import com.example.demo.repository.FormateurRepository;
import com.example.demo.repository.FormationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FormationServiceImpl implements FormationService {
    private final FormationRepository formationRepository;
    private final FormateurRepository formateurRepository;

    public FormationServiceImpl(FormationRepository formationRepository, FormateurRepository formateurRepository) {
        this.formationRepository = formationRepository;
        this.formateurRepository = formateurRepository;
    }

    @Override
    public Formation creer(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> Lire() {
        return formationRepository.findAll();
    }

    @Override
    public Formation modifier(int id, Formation formation) {
        return formationRepository.findById(id)
                .map(f-> {
                    f.setNom(formation.getNom());
                    f.setPrix(formation.getPrix());
                    f.setDate_debut(formation.getDate_debut());
                    f.setDate_fin(formation.getDate_fin());
                    return formationRepository.save(f);
                }).orElseThrow(() -> new RuntimeException("formation non trouvé !"));
    }



    @Override
    public String supprimer(int id) {
        this.formationRepository.deleteById(id);
        return "Formation supprimé";
    }

    public boolean affecterFormateur(int formationId, int formateurId) {
        Formation formation = formationRepository.findById(formationId).orElse(null);
        Formateur formateur = formateurRepository.findById(formateurId).orElse(null);

        if (formation != null && formateur != null) {
            formation.setFormateur(formateur);
            formationRepository.save(formation);
            return true;
        } else {
            return false;
        }
    }
}
