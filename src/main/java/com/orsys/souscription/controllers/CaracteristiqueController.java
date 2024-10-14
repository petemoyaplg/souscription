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

import com.orsys.souscription.models.Caracteristique;
import com.orsys.souscription.services.CaracteristiqueService;

@RestController
@RequestMapping("caracteristique")
public class CaracteristiqueController {
    @Autowired
    private CaracteristiqueService caracteristiqueService;

    @GetMapping("list")
    private ResponseEntity<List<Caracteristique>> findAll() {
        List<Caracteristique> caracts = caracteristiqueService.findAll();
        return ResponseEntity.ok().body(caracts);
    }

    @GetMapping("list/produit/{idProduit}")
    private ResponseEntity<List<Caracteristique>> findAllByProduit(@PathVariable("idProduit") UUID idProduit) {
        List<Caracteristique> caracts = caracteristiqueService.findAllByProduit(idProduit);
        return ResponseEntity.ok().body(caracts);
    }

    @PostMapping("create/{idProduit}")
    private ResponseEntity<Caracteristique> create(@RequestBody Caracteristique caract,
            @PathVariable("idProduit") UUID idProduit) {
        System.out.println(caract);
        Caracteristique response = caracteristiqueService.create(caract, idProduit);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
