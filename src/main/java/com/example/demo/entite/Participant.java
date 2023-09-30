package com.example.demo.entite;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "participant")
public class Participant extends Utilisateur{

}
