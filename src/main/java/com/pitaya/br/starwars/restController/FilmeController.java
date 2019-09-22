package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.FilmeDTO;
import com.pitaya.br.starwars.model.Filme;
import com.pitaya.br.starwars.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody Filme filme){
        if(filme!=null){
            filmeService.salvar(filme);
            return ResponseEntity.ok(filme);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody Filme filme){
        if(filme!=null){
            filmeService.atualizar(filme);return ResponseEntity.ok(filme);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Integer id){
        filmeService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
