package com.orsys.souscription.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orsys.souscription.models.Caracteristique;
import com.orsys.souscription.models.Produit;

public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, UUID> {
    List<Caracteristique> findByProduit(Produit produit);
}
