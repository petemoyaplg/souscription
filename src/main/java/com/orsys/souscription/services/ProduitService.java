package com.orsys.souscription.services;

import com.orsys.souscription.models.Produit;
import com.orsys.souscription.models.TypeProduit;
import com.orsys.souscription.repositories.ProduitRepository;
import com.orsys.souscription.repositories.TypeProduitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private TypeProduitRepository typeProduitRepository;

    public List<Produit> findAll(){
        return this.produitRepository.findAll();
    }

    @Transactional
    public Produit create(Produit produit, UUID idType) {
        // Find the TypeProduit by ID and associate it with the Produit
        Optional<TypeProduit> typeProduit = typeProduitRepository.findById(idType);

        if (typeProduit.isPresent()) {
            produit.setIdType(typeProduit.get()); // Set the TypeProduit to the Produit
            return this.produitRepository.save(produit); // Save and return the new Produit
        } else {
            throw new RuntimeException("Produit not found with id: " + idType);
        }
    }
}
