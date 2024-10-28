package com.orsys.souscription.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orsys.souscription.dto.CreateScriptDto;
import com.orsys.souscription.models.Script;
import com.orsys.souscription.repositories.ScriptRepository;

@Service
public class ScriptService {

    @Autowired
    ScriptRepository scriptRepository;

    public Script saveScript(CreateScriptDto createScriptDto) {

        Script script = new Script();

        script.setContent(createScriptDto.getContent());

        return this.scriptRepository.save(script);

    }

    public List<Script> getScripts(){
        return this.scriptRepository.findAll();
    }

    public Script getScript(){
        List<Script> scripts = this.scriptRepository.findAll();

        if (!scripts.isEmpty()) return scripts.get(0);

        return null;
    }

}
