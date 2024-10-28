package com.orsys.souscription.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Update {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;
    LocalDate date;
}
