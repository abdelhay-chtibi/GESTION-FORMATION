package com.example.demo.entite;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table( name = "utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur extends Personne {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    @Column(unique = true)
    private String email;
    @Column (name = "mot_de_passe")
    @Size(max=20)
    private String mdp;


}
