package com.example.demo.service;

import com.example.demo.entite.Formation;
import com.example.demo.repository.FormationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FormationServiceImpl implements FormationService {
    private final FormationRepository formationRepository;

    public FormationServiceImpl(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
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
        return null;
    }

    @Override
    public String supprimer(int id) {
        return null;
    }
}
