package com.orsys.souscription.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsys.souscription.dto.CreateUpdateDto;
import com.orsys.souscription.models.Update;
import com.orsys.souscription.services.UpdateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("update")
public class UpdateController {

    @Autowired
    UpdateService updateService;

    @PostMapping("add")
    public ResponseEntity<Update> create(@RequestBody CreateUpdateDto createUpdateDto) {

        Update update = this.updateService.createUpdate(createUpdateDto);

        return ResponseEntity.ok().body(update);
    }

    @GetMapping("list")
    public ResponseEntity<List<Update>> getUpdates() {
        List<Update> updates = this.updateService.getUpdates();
        return ResponseEntity.ok().body(updates);
    }

}
