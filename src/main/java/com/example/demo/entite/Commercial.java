package com.example.demo.entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "commercial")
public class Commercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
