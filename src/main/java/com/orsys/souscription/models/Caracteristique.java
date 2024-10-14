package com.orsys.souscription.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "caracteristique")
@Getter
@Setter
public class Caracteristique {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "longueur")
    private Integer longueur;

    @Column(name = "position")
    private Integer position;

    @Column(name = "num_interface")
    private Integer numInterface;

    @Column(name = "valeur_par_defaut")
    private String valeurParDefaut;

    @Column(name = "devis", nullable = false)
    private boolean devis;

    @Column(name = "obligatoire", nullable = false)
    private boolean obligatoire;

    @Column(name = "accessible", nullable = false)
    private boolean accessible;

    @Column(name = "ordre_affichage")
    private int ordreAffichage;

    // @Column(name = "list_valeur", columnDefinition = "json")
    // private String listValeur;

}
