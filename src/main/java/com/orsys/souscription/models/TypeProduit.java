package com.orsys.souscription.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "type_produit")
@Getter
@Setter
public class TypeProduit {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @Column(name = "couleur")
    private String couleur;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "idType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produit> produits = new ArrayList<>();
}
