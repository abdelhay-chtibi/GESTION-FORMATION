package com.example.demo.entite;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "rendez_vous")
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_commercial")
    private Commercial commercial;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prospect")
    private Prospect prospect;

}
