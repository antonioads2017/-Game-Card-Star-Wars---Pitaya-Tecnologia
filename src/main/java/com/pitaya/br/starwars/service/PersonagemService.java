package com.pitaya.br.starwars.service;

import com.pitaya.br.starwars.error.ResourceNotFoundException;
import com.pitaya.br.starwars.model.*;
import com.pitaya.br.starwars.model.DTOs.PersonagemDTO;
import com.pitaya.br.starwars.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {


    private static final String PATH = "https://starwarsgc-api.herokuapp.com";

    @Autowired
    private PersonagemRepository personagemRepository;

    public PersonagemDTO getPersonagem(Integer id){
        Personagem personagem = personagemRepository.findById(id).get();
        if (personagem != null) {
            PersonagemDTO personagemDTO = new PersonagemDTO();
            personagemDTO.setId(id);
            personagemDTO.setNome(personagem.getNome());
            personagemDTO.setAltura(personagem.getAltura());
            personagemDTO.setPeso(personagem.getPeso());
            personagemDTO.setSexo(personagem.getSexo());
            personagemDTO.setAnoDeNascimento(personagem.getAnoDeNascimento());
            personagemDTO.setEspecie(PATH+"/especie/"+personagem.getEspecie().getId());
            personagemDTO.setPlaneta(PATH+"/planeta/"+personagem.getPlaneta().getId());
            List<String> filmes = new ArrayList<>();
            List<String> naves = new ArrayList<>();
            List<String> veiculos = new ArrayList<>();
            for(Filme filme : personagem.getFilmes()){
                String string = PATH+"/filme/"+filme.getId();
                filmes.add(string);
            }
            for(Nave nave : personagem.getNaves()){
                String string = PATH+"/nave/"+nave.getId();
                naves.add(string);
            }
            for(Veiculo veiculo : personagem.getVeiculos()){
                String string = PATH+"/veiculo/"+veiculo.getId();
                veiculos.add(string);
            }
            personagemDTO.setFilmes(filmes);
            personagemDTO.setNaves(naves);
            personagemDTO.setVeiculos(veiculos);


            return personagemDTO;
        }else{
            throw new ResourceNotFoundException("Personagem nao encontrado");
        }

    }

    public List<PersonagemDTO> listar(){
        List<Personagem> personagens = personagemRepository.findAll();
        List<PersonagemDTO> personagensDTOs = new ArrayList<>();
        for(Personagem personagem:personagens){
            personagensDTOs.add(getPersonagem(personagem.getId()));
        }
        return personagensDTOs;
    }

    public void salvar(Personagem personagem){
        if(personagemRepository.findById(personagem.getId())==null){
            personagemRepository.save(personagem);
        }
    }

    public void atualizar(Personagem personagem){
        if(personagemRepository.findById(personagem.getId())!=null){
            personagemRepository.save(personagem);
        }else{
            throw new ResourceNotFoundException("Personagem nao encontrado");
        }
    }

    public void excluir(Integer id){
        if(personagemRepository.findById(id)!=null){
            Optional<Personagem> personagem = personagemRepository.findById(id);
            personagemRepository.delete(personagem.get());
        }else{
            throw new ResourceNotFoundException("Personagem nao encontrado");
        }
    }



}
