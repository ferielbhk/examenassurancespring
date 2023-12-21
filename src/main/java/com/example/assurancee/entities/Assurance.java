package com.example.assurancee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAssurance")
    private Long idAssurance;
    private String designation ;
    private float montant ;
    @ManyToOne
    private Beneficaire beneficaire ;
    @ManyToOne(cascade = CascadeType.ALL)
    Contrat contrat ;
}
