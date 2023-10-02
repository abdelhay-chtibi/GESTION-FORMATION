package com.example.demo.service;

import com.example.demo.entite.Formateur;
import com.example.demo.repository.FormateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurServiceImpl implements FormateurService{
    private final FormateurRepository formateurRepository;

    public FormateurServiceImpl(FormateurRepository formateurRepository) {
        this.formateurRepository = formateurRepository;
    }

    @Override
    public Formateur creer(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> Lire() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur modifier(int id, Formateur formateur) {
        return formateurRepository.findById(id)
                .map(f-> {
                    f.setNom(formateur.getNom());
                    f.setPrenom(formateur.getPrenom());
                    f.setEmail(formateur.getEmail());
                    f.setDate_naissance(formateur.getDate_naissance());
                    f.setSexe(formateur.getSexe());
                    f.setMdp(formateur.getMdp());
                    return formateurRepository.save(f);
                }).orElseThrow(() -> new RuntimeException("Formateur non trouvé !"));
    }



    @Override
    public String supprimer(int id) {
        this.formateurRepository.deleteById(id);
        return "Formateur supprimé";
    }
}
