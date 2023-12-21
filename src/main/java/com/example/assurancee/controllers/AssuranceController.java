package com.example.assurancee.controllers;

import com.example.assurancee.entities.Assurance;
import com.example.assurancee.entities.Beneficaire;
import com.example.assurancee.entities.Contrat;
import com.example.assurancee.entities.TypeContrat;
import com.example.assurancee.services.BeneficaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
public class AssuranceController {
    BeneficaireService beneficaireService ;
    @PostMapping("/ajout-banque")
    public Long ajouterBeneficaire(@RequestBody Beneficaire bf){
        return beneficaireService.ajouterBeneficaire(bf);
    }
    @PostMapping("/ajouter-assurance/{cinBf}")
    public Long ajouterassurance (@RequestBody Assurance a ,@PathVariable("cinBf") Long cinBf){
        return beneficaireService.ajouterAssurance(a , cinBf);
    }
    @GetMapping("/oldest/{idBeneficiaire}")
    public ResponseEntity<Contrat> getOldestContrat(@PathVariable Long idBeneficiaire) {
        Contrat oldestContract = beneficaireService.getContratBf(idBeneficiaire);

        if (oldestContract != null) {
            return new ResponseEntity<>(oldestContract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/montant/{cinBf}")
    public float getmontant(@PathVariable("cinBf") Long cinBf){
        return beneficaireService.getMontantBf(cinBf);
    }
    @GetMapping("/beneficaire/{typeC}")
    public Set<Beneficaire> getbeneficairepartype(@PathVariable("typeC")TypeContrat tc){
        return beneficaireService.getBeneficairesAsType(tc);
    }
}
