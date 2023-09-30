package com.example.demo.entite;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "formation")
public class Cours {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

}
