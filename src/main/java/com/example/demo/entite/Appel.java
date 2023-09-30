package com.example.demo.entite;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "appel")
public class Appel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date_appel;
    private String resume;
    private Date relance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_commercial")
    private Commercial commercial;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prospect")
    private Prospect prospect;


}
