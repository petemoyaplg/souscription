package com.orsys.souscription.controllers;


import com.orsys.souscription.models.TypeProduit;
import com.orsys.souscription.services.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type-produit")
public class TypeProduitController {
    @Autowired
    private TypeProduitService typeProduitService;

    @GetMapping("list")
    private ResponseEntity<List<TypeProduit>> findAll() {
        List<TypeProduit> typeProduits = typeProduitService.findAll();
        return ResponseEntity.ok().body(typeProduits);
    }

    @PostMapping("create")
    private ResponseEntity<TypeProduit> create(@RequestBody TypeProduit typeProduit) {
        TypeProduit response = typeProduitService.create(typeProduit);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
