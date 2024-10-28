package com.orsys.souscription.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orsys.souscription.models.Script;

public interface ScriptRepository extends JpaRepository<Script,UUID>{

}
