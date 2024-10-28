package com.orsys.souscription.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orsys.souscription.dto.CreateUpdateDto;
import com.orsys.souscription.models.Update;
import com.orsys.souscription.repositories.UpdateRepository;

@Service
public class UpdateService {

    @Autowired
    UpdateRepository updateRepository;

    public Update createUpdate(CreateUpdateDto createUpdateDto){
        Update update = new Update();

        update.setDate(createUpdateDto.getDate());
        
        this.updateRepository.save(update);

        return update;
    }

    public List<Update> getUpdates(){
       return this.updateRepository.findAll();
    }
    
}
