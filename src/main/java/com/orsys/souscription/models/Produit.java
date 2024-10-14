package com.orsys.souscription.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "produit")
@Getter
@Setter
public class Produit {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private TypeProduit idType;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "images", nullable = false)
    private boolean images;

    @Column(name = "description")
    private String description;

    @Column(name = "nb_interface", columnDefinition = "int default 1")
    private int nbInterface;

    // These fields are now defined as TEXT in the database
    @Column(name = "image_logo", columnDefinition = "TEXT")
    private String imageLogo;

    @Column(name = "image_ariere1", columnDefinition = "TEXT")
    private String imageAriere1;

    @Column(name = "image_ariere2", columnDefinition = "TEXT")
    private String imageAriere2;
}

