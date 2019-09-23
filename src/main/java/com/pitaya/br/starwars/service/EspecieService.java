package com.pitaya.br.starwars.service;

import com.pitaya.br.starwars.error.ResourceNotFoundException;
import com.pitaya.br.starwars.model.DTOs.EspecieDTO;
import com.pitaya.br.starwars.model.Especie;
import com.pitaya.br.starwars.model.Filme;
import com.pitaya.br.starwars.model.Personagem;
import com.pitaya.br.starwars.repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EspecieService {

    private static final String PATH = "http://localhost:8090";

    @Autowired
    private EspecieRepository especieRepository;

    public EspecieDTO getEspecie(Integer id){
        Especie especie = especieRepository.findById(id).get();
        if(especie!=null){
            EspecieDTO especieDTO = new EspecieDTO();
            especieDTO.setId(especie.getId());
            especieDTO.setNome(especie.getNome());
            especieDTO.setLinguagem(especie.getLinguagem());
            especieDTO.setPlaneta(PATH+"/planeta/"+especie.getPlaneta().getId());
            List<String> personagens = new ArrayList<>();
            List<String> filmes = new ArrayList<>();
            for(Personagem p:especie.getPersonagems()){
                String string = PATH+"/personagem/"+p.getId();
                personagens.add(string);
            }
            for(Filme filme:especie.getFilmes()){
                String string = PATH+"/filme/"+filme.getId();
            }

            especieDTO.setFilmes(filmes);
            especieDTO.setPersonagens(personagens);

            return especieDTO;
        }else{
            throw new ResourceNotFoundException("Especie não encontrada");
        }
    }

    public List<EspecieDTO> listar(){
        List<Especie> especies = especieRepository.findAll();
        List<EspecieDTO> especieDTOS = new ArrayList<>();
        for(Especie especie:especies){
            especieDTOS.add(getEspecie(especie.getId()));
        }
        return especieDTOS;
    }

    public void salvar(Especie especie){
        if(especie!=null){
            especieRepository.save(especie);
        }
    }

    public void atualizar(Especie especie){
        if(especieRepository.findById(especie.getId())!=null){
            especieRepository.save(especie);
        }else{
            throw new ResourceNotFoundException("Especie não encotrada");
        }
    }

    public void excluir (Integer id){
        if(especieRepository.findById(id)!=null){
            Optional<Especie> especie = especieRepository.findById(id);
            especieRepository.delete(especie.get());
        }else{
            throw  new ResourceNotFoundException("Especie não encontrada");
        }
    }

}

