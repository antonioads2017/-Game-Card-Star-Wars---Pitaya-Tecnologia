package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.PlanetaDTO;
import com.pitaya.br.starwars.model.Planeta;
import com.pitaya.br.starwars.service.PlanetaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API Rest StarWars Planeta")
@RestController
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @ApiOperation(value = "Retorna um planeta")
    @GetMapping("/{id}")
    public ResponseEntity<PlanetaDTO> buscar(@PathVariable("id") Integer id){
        PlanetaDTO planetaDTO = planetaService.getPlaneta(id);
        return planetaDTO!=null ? ResponseEntity.ok(planetaDTO) : ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Retorna uma lista de planetas")
    @GetMapping
    public ResponseEntity<List<PlanetaDTO>> listar(){
        List<PlanetaDTO> planetas = planetaService.listar();
        return planetas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(planetas);
    }

    @ApiOperation(value = "Salva um planeta")
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody Planeta planeta){
        if(planeta!=null){
            planetaService.salvar(planeta);
            return ResponseEntity.ok(planeta);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @ApiOperation(value = "Atualiza um planeta")
    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody Planeta planeta){
        if(planeta!=null){
            planetaService.atualizar(planeta);
            return ResponseEntity.ok(planeta);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @ApiOperation(value = "Deleta um planeta")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Integer id){
        planetaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
