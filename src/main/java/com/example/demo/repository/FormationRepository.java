package com.example.demo.repository;

import com.example.demo.entite.Formation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
    List<Formation> findByNom(String nom);
}
