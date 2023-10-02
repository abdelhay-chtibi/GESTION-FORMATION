package com.example.demo.entite;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "formateur")
public class Formateur extends Utilisateur {
    @OneToMany(cascade = CascadeType.ALL)
    private List<Formation> formations;

}
