package com.orsys.souscription.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orsys.souscription.models.Update;

public interface UpdateRepository extends JpaRepository<Update, UUID> {
    
}
