package com.orsys.souscription.controllers;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsys.souscription.models.Produit;
import com.orsys.souscription.services.ProduitService;

@RestController
@RequestMapping("produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("list")
    private ResponseEntity<List<Produit>> findAll() {
        List<Produit> produits = produitService.findAll();
        return ResponseEntity.ok().body(produits);
    }

    @PostMapping("create/{idType}")
    private ResponseEntity<Produit> create(@RequestBody Produit produit, @PathVariable("idType") UUID idType) {
        Produit response = produitService.create(produit, idType);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
