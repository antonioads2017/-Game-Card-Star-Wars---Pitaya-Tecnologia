package com.pitaya.br.starwars.service;

import com.pitaya.br.starwars.error.ResourceNotFoundException;
import com.pitaya.br.starwars.model.DTOs.NaveDTO;
import com.pitaya.br.starwars.model.Filme;
import com.pitaya.br.starwars.model.Nave;
import com.pitaya.br.starwars.model.Personagem;
import com.pitaya.br.starwars.repository.NaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NaveService {

    private static final String PATH = "https://starwarsgc-api.herokuapp.com";

    @Autowired
    private NaveRepository naveRepository;

    public NaveDTO getNave(Integer id){
        Nave nave = naveRepository.findById(id).get();
        if(nave!=null){
            NaveDTO naveDTO = new NaveDTO();
            naveDTO.setId(nave.getId());
            naveDTO.setNome(nave.getNome());
            naveDTO.setModelo(nave.getModelo());
            naveDTO.setClasseNave(nave.getClasseNave());
            naveDTO.setFabricante(nave.getFabricante());
            naveDTO.setTamanho(nave.getTamanho());
            naveDTO.setCapacidadeDeCarga(nave.getCapacidadeDeCarga());
            naveDTO.setVelocidadeMaxima(nave.getVelocidadeMaxima());
            List<String> pilotos = new ArrayList<>();
            List<String> filmes = new ArrayList<>();

            for(Personagem personagem: nave.getPilotos()){
                String string = PATH+"/personagem/"+personagem.getId();
                pilotos.add(string);
            }
            for(Filme filme:nave.getFilmes()){
                String string = PATH+"/filme/"+filme.getId();
                filmes.add(string);
            }
            naveDTO.setPilotos(pilotos);
            naveDTO.setFilmes(filmes);

            return naveDTO;
        }else{
            throw new ResourceNotFoundException("Nave não encontrada");
        }
    }

    public List<NaveDTO> listar(){
        List<Nave> naves = naveRepository.findAll();
        List<NaveDTO> navesDTOS = new ArrayList<>();
        for(Nave nave:naves){
            navesDTOS.add(getNave(nave.getId()));
        }
        return navesDTOS;
    }

    public void salvar(Nave nave){
        if(naveRepository.findById(nave.getId())==null){
            naveRepository.save(nave);
        }
    }

    public void atualizar(Nave nave){
        if(naveRepository.findById(nave.getId())!=null){
            naveRepository.save(nave);
        }else{
            throw new ResourceNotFoundException("Nave não encotrada");
        }
    }

    public void excluir (Integer id){
        if(naveRepository.findById(id)!=null){
            Optional<Nave> nave = naveRepository.findById(id);
            naveRepository.delete(nave.get());
        }else{
            throw  new ResourceNotFoundException("Nave não encontrada");
        }
    }
}
