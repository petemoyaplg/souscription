package com.orsys.souscription.services;

import com.orsys.souscription.models.TypeProduit;
import com.orsys.souscription.repositories.TypeProduitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProduitService {
    @Autowired
    private TypeProduitRepository typeProduitRepository;

    public List<TypeProduit> findAll(){
        return this.typeProduitRepository.findAll();
    }

    @Transactional
    public TypeProduit create(TypeProduit typeProduit) {
        return this.typeProduitRepository.save(typeProduit);
    }
}
