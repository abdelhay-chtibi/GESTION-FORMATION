package com.example.demo.entite;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Entity
@Table( name = "prospect")
public class Prospect extends Personne{
    @Size(max=10)
    private String telephone;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Appel> appels;
}
