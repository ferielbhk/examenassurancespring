package com.example.assurancee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beneficaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBeneficaire")
    private Long idBenef;
    private Long cin ;
    private String nom ;
    private String prenom ;
    private String profession ;
    private  float salaire ;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "beneficaire")
    private List<Assurance>assurances;

}
