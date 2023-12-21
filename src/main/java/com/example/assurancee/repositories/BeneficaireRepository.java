package com.example.assurancee.repositories;

import com.example.assurancee.entities.Beneficaire;
import com.example.assurancee.entities.Contrat;
import com.example.assurancee.entities.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BeneficaireRepository extends JpaRepository<Beneficaire , Long> {
    Beneficaire findByCin(Long cinBf);
    @Query("SELECT DISTINCT b FROM Beneficaire b JOIN b.assurances a JOIN a.contrat c WHERE c.type = :tc")
    Set<Beneficaire> findAllBeneficiairesByTypeContrat(@Param("tc") TypeContrat tc);

}
