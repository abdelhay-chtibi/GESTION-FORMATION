package com.example.demo.entite;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "participant")
public class Participant extends Utilisateur{
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeParticipation = new Date();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Formation> formations;
}
