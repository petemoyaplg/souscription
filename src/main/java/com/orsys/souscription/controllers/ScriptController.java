package com.orsys.souscription.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsys.souscription.dto.CreateScriptDto;
import com.orsys.souscription.models.Script;
import com.orsys.souscription.services.ScriptService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("script")
public class ScriptController {
    @Autowired
    ScriptService scriptService;

    @PostMapping("add")
    public ResponseEntity<Script> create(@RequestBody CreateScriptDto scriptDto) {
        Script script = this.scriptService.saveScript(scriptDto);
        return ResponseEntity.ok(script);
    }


    @GetMapping("list")
    public ResponseEntity<List<Script>> get() {
       List<Script> scripts = this.scriptService.getScripts();
        return ResponseEntity.ok(scripts);
    }


    @GetMapping("all")
    public ResponseEntity<Script> getScript() {
       Script script = this.scriptService.getScript();
        return ResponseEntity.ok(script);
    }
}
