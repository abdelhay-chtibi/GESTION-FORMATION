package com.example.demo.entite;
import com.example.demo.enums.Sexe;
import lombok.Data;
import java.util.Date;

import javax.persistence.*;
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;




}
