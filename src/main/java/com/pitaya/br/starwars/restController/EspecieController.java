package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.EspecieDTO;
import com.pitaya.br.starwars.model.Especie;
import com.pitaya.br.starwars.service.EspecieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API REST StarWars Especie")
@RestController
@RequestMapping("/especie")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @ApiOperation(value = "Retorna uma especie")
    @GetMapping("/{id}")
    public ResponseEntity<EspecieDTO> buscar(@PathVariable("id") Integer id){
        EspecieDTO especieDTO = especieService.getEspecie(id);
        return especieDTO!=null ? ResponseEntity.ok(especieDTO) : ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Retorna uma lista de especies")
    @GetMapping
    public ResponseEntity<List<EspecieDTO>> listar(){
        List<EspecieDTO> especies = especieService.listar();
        return especies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(especies);
    }

    @ApiOperation(value = "Salva uma especie")
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody Especie especie){
        if(especie!=null){
            especieService.salvar(especie);
            return ResponseEntity.ok(especie);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @ApiOperation(value = "Atualiza uma especie")
    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody Especie especie){
        if(especie!=null){
            especieService.atualizar(especie);
            return ResponseEntity.ok(especie);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @ApiOperation(value = "Deleta uma especie")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Integer id){
        especieService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
