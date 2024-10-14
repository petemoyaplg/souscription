package com.orsys.souscription.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.orsys.souscription.models.Caracteristique;
import com.orsys.souscription.models.Produit;
import com.orsys.souscription.repositories.CaracteristiqueRepository;
import com.orsys.souscription.repositories.ProduitRepository;

import jakarta.transaction.Transactional;

@Service
public class CaracteristiqueService {
    @Autowired
    private CaracteristiqueRepository caracteristiqueRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<Caracteristique> findAll() {
        Sort positionSort = Sort.by(Direction.ASC, "position");
    Sort numInterfaceSort = Sort.by(Direction.ASC, "numInterface");

    Sort groupBySort = numInterfaceSort.and(positionSort);
    return this.caracteristiqueRepository.findAll(groupBySort);
    }

    public List<Caracteristique> findAllByProduit(UUID idProduit) {
        // Find the TypeProduit by ID and associate it with the Produit
        Optional<Produit> produit = produitRepository.findById(idProduit);
        if (produit.isPresent()) {
            return this.caracteristiqueRepository.findByProduit(produit.get()); // Save and return the new Produit
        } else {
            throw new RuntimeException("Produit not found with id: " + idProduit);
        }
    }

    @Transactional
    public Caracteristique create(Caracteristique caracte, UUID idProduit) {
        // Find the TypeProduit by ID and associate it with the Produit
        Optional<Produit> produit = produitRepository.findById(idProduit);

        if (produit.isPresent()) {
            caracte.setProduit(produit.get()); // Set the TypeProduit to the Produit
            // caracte.setListValeur(null);
            // return caracte; // Save and return the new Produit
            return this.caracteristiqueRepository.save(caracte); // Save and return the new Produit
        } else {
            throw new RuntimeException("Produit not found with id: " + idProduit);
        }
    }
}
