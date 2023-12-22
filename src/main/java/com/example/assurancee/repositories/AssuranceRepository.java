package com.example.assurancee.repositories;

import com.example.assurancee.entities.Assurance;
import com.example.assurancee.entities.Beneficaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance , Long> {
    Long countByBeneficaire(Beneficaire bf);
}
