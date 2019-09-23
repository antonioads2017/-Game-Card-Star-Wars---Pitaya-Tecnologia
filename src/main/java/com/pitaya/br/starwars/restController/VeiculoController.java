package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.NaveDTO;
import com.pitaya.br.starwars.model.DTOs.VeiculoDTO;
import com.pitaya.br.starwars.model.Nave;
import com.pitaya.br.starwars.model.Veiculo;
import com.pitaya.br.starwars.service.NaveService;
import com.pitaya.br.starwars.service.VeiculoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API Rest StarWars Veiculo")
@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @ApiOperation(value = "Retorna um veiculo")
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> buscar(@PathVariable("id") Integer id){
        VeiculoDTO veiculo = veiculoService.getVeiculo(id);
        return veiculo!=null ? ResponseEntity.ok(veiculo) : ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Retorna uma lista de veiculos")
    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> listar(){
        List<VeiculoDTO> veiculos = veiculoService.listar();
        return veiculos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(veiculos);
    }

    @ApiOperation(value = "Salva um veiculo")
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody Veiculo veiculo){
        if(veiculo!=null){
            veiculoService.salvar(veiculo);
            return ResponseEntity.ok(veiculo);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @ApiOperation(value = "Atualiza um veiculo")
    @PutMapping
    public ResponseEntity<Object> atualizar(@RequestBody Veiculo veiculo){
        if(veiculo!=null){
            veiculoService.atualizar(veiculo);
            return ResponseEntity.ok(veiculo);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @ApiOperation(value = "Deleta um veiculo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Integer id){
        veiculoService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
