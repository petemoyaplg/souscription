package com.orsys.souscription.repositories;

import com.orsys.souscription.models.TypeProduit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TypeProduitRepository extends JpaRepository<TypeProduit, UUID> {
}
