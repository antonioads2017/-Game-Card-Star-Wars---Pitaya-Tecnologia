package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.FilmeDTO;
import com.pitaya.br.starwars.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> buscar(@PathVariable("id") Integer id){
        FilmeDTO filmeDTO = filmeService.getFilme(id);
        return filmeDTO!=null ? ResponseEntity.ok(filmeDTO) : ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> listar(){
        List<FilmeDTO> filmes = filmeService.listar();
        return filmes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(filmes);
    }

}
