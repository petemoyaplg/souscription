package com.orsys.souscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orsys.souscription.repositories.CaracteristiqueRepository;

@SpringBootApplication
public class SouscriptionApplication implements CommandLineRunner {

    @Autowired
    private CaracteristiqueRepository caracteristiqueRepository;

    public static void main(String[] args) {
        SpringApplication.run(SouscriptionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.caracteristiqueRepository.findAll();
    }

}
