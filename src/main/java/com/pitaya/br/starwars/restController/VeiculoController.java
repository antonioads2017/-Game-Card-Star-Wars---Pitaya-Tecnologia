package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.NaveDTO;
import com.pitaya.br.starwars.model.DTOs.VeiculoDTO;
import com.pitaya.br.starwars.model.Nave;
import com.pitaya.br.starwars.model.Veiculo;
import com.pitaya.br.starwars.service.NaveService;
import com.pitaya.br.starwars.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> buscar(@PathVariable("id") Integer id){
        VeiculoDTO veiculo = veiculoService.getVeiculo(id);
        return veiculo!=null ? ResponseEntity.ok(veiculo) : ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> listar(){
        List<VeiculoDTO> veiculos = veiculoService.listar();
        return veiculos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(veiculos);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Integer id){
        veiculoService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
