package com.example.demo.entite;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Float prix;
    private Date date_debut;
    private Date date_fin;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Cours> cours;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Participant> participants;

    // Relation avec Formateur
    @ManyToOne
    @JoinColumn(name = "id_formateur")
    private Formateur formateur;
}
