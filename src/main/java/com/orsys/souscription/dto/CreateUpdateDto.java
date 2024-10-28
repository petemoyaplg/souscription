package com.orsys.souscription.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateUpdateDto {
    int version;
    LocalDate date;
}
