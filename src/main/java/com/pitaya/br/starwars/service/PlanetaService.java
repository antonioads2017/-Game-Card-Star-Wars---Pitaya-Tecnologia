package com.pitaya.br.starwars.service;

import com.pitaya.br.starwars.error.ResourceNotFoundException;
import com.pitaya.br.starwars.model.DTOs.PlanetaDTO;
import com.pitaya.br.starwars.model.Filme;
import com.pitaya.br.starwars.model.Personagem;
import com.pitaya.br.starwars.model.Planeta;
import com.pitaya.br.starwars.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanetaService {

    private static final String PATH = "http://localhost:8090";

    @Autowired
    private PlanetaRepository planetaRepository;

    public PlanetaDTO getPlaneta(Integer id){
        Planeta planeta = planetaRepository.findById(id).get();
        if(planeta!=null){
            PlanetaDTO planetaDTO = new PlanetaDTO();
            planetaDTO.setId(planeta.getId());
            planetaDTO.setClima(planeta.getClima());
            planetaDTO.setNome(planeta.getNome());
            planetaDTO.setGravidade(planeta.getGravidade());
            planetaDTO.setPopulacao(planeta.getPopulacao());
            List<String> filmes = new ArrayList<>();
            List<String> residentes = new ArrayList<>();
            for(Filme filme:planeta.getFilmes()){
                String string  = PATH+"/filme/"+filme.getId();
                filmes.add(string);
            }
            for(Personagem personagem:planeta.getResidentes()){
                String string = PATH+"/personagem/"+personagem.getId();
                residentes.add(string);
            }
            planetaDTO.setResidentes(residentes);
            planetaDTO.setFilmes(filmes);
            return  planetaDTO;
        }else{
            throw new ResourceNotFoundException("Planeta nao encontrado");
        }
    }

    public List<PlanetaDTO> listar(){
        List<Planeta> planetas = planetaRepository.findAll();
        List<PlanetaDTO> planetaDTOS = new ArrayList<>();
        for(Planeta planeta:planetas){
            planetaDTOS.add(getPlaneta(planeta.getId()));
        }
        return planetaDTOS;
    }

    public void salvar(Planeta planeta){
        if(planeta!=null){
            planetaRepository.save(planeta);
        }
    }

    public void atualizar(Planeta planeta){
        if(planetaRepository.findById(planeta.getId())!=null){
            planetaRepository.save(planeta);
        }else{
            throw new ResourceNotFoundException("Especie não encotrada");
        }
    }

    public void excluir (Integer id){
        if(planetaRepository.findById(id)!=null){
            Optional<Planeta> planeta = planetaRepository.findById(id);
            planetaRepository.delete(planeta.get());
        }else{
            throw  new ResourceNotFoundException("Especie não encontrada");
        }
    }
}
