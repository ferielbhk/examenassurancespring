package com.example.assurancee.services;

import com.example.assurancee.entities.Contrat;
import com.example.assurancee.entities.TypeContrat;
import com.example.assurancee.repositories.AssuranceRepository;
import com.example.assurancee.repositories.BeneficaireRepository;
import com.example.assurancee.repositories.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.assurancee.entities.Beneficaire;
import com.example.assurancee.entities.Assurance;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BeneficaireService {
    AssuranceRepository assuranceRepository;
    ContratRepository contratRepository ;
    BeneficaireRepository beneficaireRepository ;
    public Long ajouterBeneficaire (Beneficaire bf){
            return beneficaireRepository.save(bf).getCin();
    }
    public Long ajouterAssurance (Assurance a, Long cinBf){
        Beneficaire beneficaire = beneficaireRepository.findByCin(cinBf);
        a.setBeneficaire(beneficaire);
        Contrat c = contratRepository.save(a.getContrat());
        a.setContrat(c);
        return assuranceRepository.save(a).getIdAssurance();
    }
    public Contrat getContratBf (Long idBf){
        return contratRepository.findOldestContratForBeneficiaire(idBf).get(0);
    }
    public float getMontantBf (Long cinBf){
        Beneficaire beneficaire = beneficaireRepository.findByCin(cinBf);
        float mont=0;

        for (Assurance as:beneficaire.getAssurances()){
            if (as.getContrat().getType().equals("Annuel")){
                mont+=as.getMontant();
            } else if (as.getContrat().getType().equals("Mensuel")){
                mont+= as.getMontant() * 12 ;}
            else {
                mont+= as.getMontant() * 2 ;
                }

        }
        return mont ;
    }
    public Set<Beneficaire> getBeneficairesAsType(TypeContrat tc){
        return beneficaireRepository.findAllBeneficiairesByTypeContrat(tc);
    }
}
