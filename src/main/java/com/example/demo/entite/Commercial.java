package com.example.demo.entite;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "commercial")
public class Commercial extends Utilisateur{
    @OneToMany (cascade = CascadeType.ALL)
    private List<Appel> appels;


}
