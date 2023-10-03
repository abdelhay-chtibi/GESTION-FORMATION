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

    //methode pour rechercher si on pas pas d'argument ila va afficher tout les formation 
    //et Si en pas le nom de la formation dans url il va afficher informations de la formation 
    //pour tester : http://localhost:8080/api/formation?nom=Nom1 
    @Override
    public List<Formation> rechercher(String nom) {
        if (nom == null) {
        return formationRepository.findAll();
        } else {
            return formationRepository.findByNom(nom);
        }
    }

    @Override
    public Formation modifier(int id, Formation formation) {
        return formationRepository.findById(id)
                .map(f -> {
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

    // Cette methode est utiliser pour affecter une un formateur a une formation
    @Override
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
