package com.example.demo.entite;
import com.example.demo.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

import javax.persistence.*;
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;




}
