package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.*;
import com.pitaya.br.starwars.model.DTOs.PersonagemDTO;
import com.pitaya.br.starwars.service.PersonagemService;
import com.pitaya.br.starwars.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Autowired
    private TestService testService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscar(@PathVariable("id") Integer id){
        PersonagemDTO personagemDTO = personagemService.getPersonagem(id);
        return personagemDTO!=null ? ResponseEntity.ok(personagemDTO) : ResponseEntity.noContent().build();
    }

    @GetMapping("/teste")
    public ResponseEntity<Object> teste(){
        testService.exemplo();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> listar(){
        List<PersonagemDTO> personagens = personagemService.listar();
        return personagens.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(personagens);
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody Personagem personagem){
        if(personagem!=null){
            personagemService.salvar(personagem);
            return ResponseEntity.ok(personagem);
        }else{
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }



}
