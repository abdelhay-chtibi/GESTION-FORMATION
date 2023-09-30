package com.example.demo.entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "formateur")
public class Formateur extends Utilisateur {
    @OneToMany(cascade = CascadeType.ALL)
    private List<Formation> formations;

}
