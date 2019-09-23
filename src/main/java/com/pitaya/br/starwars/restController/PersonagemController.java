package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.*;
import com.pitaya.br.starwars.model.DTOs.PersonagemDTO;
import com.pitaya.br.starwars.service.PersonagemService;
import com.pitaya.br.starwars.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API REST StarWars Personagem")
@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Autowired
    private TestService testService;

    @ApiOperation(value = "Retorna um personagem")
    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscar(@PathVariable("id") Integer id){
        PersonagemDTO personagemDTO = personagemService.getPersonagem(id);
        return personagemDTO!=null ? ResponseEntity.ok(personagemDTO) : ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Teste de insercao de personagem")
    @GetMapping("/teste")
    public ResponseEntity<Object> teste(){
        testService.exemplo();
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Retorna uma lista de personagens")
    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> listar(){
        List<PersonagemDTO> personagens = personagemService.listar();
        return personagens.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(personagens);
    }

    @ApiOperation(value = "Salva um personagem")
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

    @ApiOperation(value = "Atualiza um personagem")
    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody Personagem personagem){
        if(personagem!=null){
            personagemService.atualizar(personagem);
            return ResponseEntity.ok(personagem);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao atualizar");
        }
    }

    @ApiOperation(value = "Deleta um personagem")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar (@PathVariable("id") Integer id){
        personagemService.excluir(id);
        return ResponseEntity.ok().build();
    }




}
