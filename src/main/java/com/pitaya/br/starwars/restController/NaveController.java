package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.NaveDTO;
import com.pitaya.br.starwars.model.Nave;
import com.pitaya.br.starwars.service.NaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nave")
public class NaveController {

    @Autowired
    private NaveService naveService;

    @GetMapping("/{id}")
    public ResponseEntity<NaveDTO> buscar(@PathVariable("id") Integer id){
        NaveDTO nave = naveService.getNave(id);
        return nave!=null ? ResponseEntity.ok(nave) : ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NaveDTO>> listar(){
        List<NaveDTO> naves = naveService.listar();
        return naves.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(naves);
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody Nave nave){
        if(nave!=null){
            naveService.salvar(nave);
            return ResponseEntity.ok(nave);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody Nave nave){
        if(nave!=null){
            naveService.atualizar(nave);
            return ResponseEntity.ok(nave);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Integer id){
        naveService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
