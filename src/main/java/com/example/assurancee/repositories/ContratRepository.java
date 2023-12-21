package com.example.assurancee.repositories;

import com.example.assurancee.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat , Long> {
    @Query("SELECT a.contrat FROM Assurance a WHERE a.beneficaire.idBenef = :idBenef ORDER BY a.contrat.dateEffet ASC")
    List<Contrat> findOldestContratForBeneficiaire(@Param("idBenef") Long idBenef);

}
