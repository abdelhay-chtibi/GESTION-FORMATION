package com.example.demo.entite;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
@Table(name = "participant")
public class Participant extends Utilisateur{
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeParticipation = new Date();
}
