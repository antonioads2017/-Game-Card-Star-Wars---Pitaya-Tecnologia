package com.pitaya.br.starwars.restController;

import com.pitaya.br.starwars.model.DTOs.NaveDTO;
import com.pitaya.br.starwars.service.NaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
