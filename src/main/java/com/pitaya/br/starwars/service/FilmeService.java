package com.pitaya.br.starwars.service;

import com.pitaya.br.starwars.error.ResourceNotFoundException;
import com.pitaya.br.starwars.model.*;
import com.pitaya.br.starwars.model.DTOs.FilmeDTO;
import com.pitaya.br.starwars.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private static final String PATH = "http://localhost:8090";

    @Autowired
    private FilmeRepository filmeRepository;

    public FilmeDTO getFilme(Integer id){
        Filme filme = filmeRepository.findById(id).get();
        if(filme!=null){
            FilmeDTO filmeDTO = new FilmeDTO();
            filmeDTO.setId(filme.getId());
            filmeDTO.setTitulo(filme.getTitulo());
            filmeDTO.setEpisodio(filme.getEpisodio());
            filmeDTO.setDescricao(filme.getDescricao());
            filmeDTO.setDiretor(filme.getDiretor());
            filmeDTO.setProducao(filme.getProducao());
            filmeDTO.setDataDeLancamento(filme.getDataDeLancamento());
            List<String> personagens = new ArrayList<>();
            List<String> planetas = new ArrayList<>();
            List<String> naves = new ArrayList<>();
            List<String> veiculos = new ArrayList<>();
            List<String> especies = new ArrayList<>();
            for(Personagem personagem: filme.getPersonagems()){
                String string = PATH+"/personagem/"+personagem.getId();
                personagens.add(string);
            }
            for(Planeta planeta : filme.getPlanetas()){
                String string = PATH+"/planeta/"+planeta.getId();
                planetas.add(string);
            }
            for(Nave nave: filme.getNaves()){
                String string = PATH+"/nave/"+nave.getId();
                naves.add(string);
            }
            for(Veiculo veiculo: filme.getVeiculos()){
                String string = PATH+"/veiculo/"+veiculo.getId();
                veiculos.add(string);
            }
            for(Especie especie: filme.getEspecies()){
                String string = PATH+"/especie/"+especie.getId();
            }
            filmeDTO.setPersonagens(personagens);
            filmeDTO.setPlanetas(planetas);
            filmeDTO.setNaves(naves);
            filmeDTO.setVeiculos(veiculos);
            filmeDTO.setEspecies(especies);

            return filmeDTO;
        }else{
            throw new ResourceNotFoundException("Filme nao encontrado");
        }
    }

    public List<FilmeDTO> listar(){
        List<Filme> filmes = filmeRepository.findAll();
        List<FilmeDTO> filmesDTo = new ArrayList<>();
        for(Filme filme : filmes){
            filmesDTo.add(getFilme(filme.getId()));
        }
        return  filmesDTo;
    }

    public void salvar(Filme filme){
        if(filmeRepository.findById(filme.getId())==null){
            filmeRepository.save(filme);
        }
    }

    public void atualizar(Filme filme){
        if(filmeRepository.findById(filme.getId())!=null){
            filmeRepository.save(filme);
        }else{
            throw new ResourceNotFoundException("Filme nao encontrado");
        }
    }

    public void excluir(Integer id){
        if(filmeRepository.findById(id)!=null){
            Optional<Filme> filme = filmeRepository.findById(id);
            filmeRepository.delete(filme.get());
        }else{
            throw  new ResourceNotFoundException("Filme nao encontrado");
        }
    }
}
