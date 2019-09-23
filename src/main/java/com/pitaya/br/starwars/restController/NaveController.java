package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.NaveDTO;
import com.pitaya.br.starwars.model.Nave;
import com.pitaya.br.starwars.service.NaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API Rest StarWars Nave")
@RestController
@RequestMapping("/nave")
public class NaveController {

    @Autowired
    private NaveService naveService;

    @ApiOperation(value = "Retorna uma nave")
    @GetMapping("/{id}")
    public ResponseEntity<NaveDTO> buscar(@PathVariable("id") Integer id){
        NaveDTO nave = naveService.getNave(id);
        return nave!=null ? ResponseEntity.ok(nave) : ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Retorna uma lista de naves")
    @GetMapping
    public ResponseEntity<List<NaveDTO>> listar(){
        List<NaveDTO> naves = naveService.listar();
        return naves.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(naves);
    }

    @ApiOperation(value = "Salva uma nave")
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

    @ApiOperation(value = "Atualiza uma nave")
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

    @ApiOperation(value = "Exclui uma nave")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Integer id){
        naveService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
