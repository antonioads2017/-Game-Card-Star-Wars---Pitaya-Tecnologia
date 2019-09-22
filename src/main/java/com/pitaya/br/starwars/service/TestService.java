package com.pitaya.br.starwars.service;

import com.pitaya.br.starwars.model.*;
import com.pitaya.br.starwars.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private EspecieRepository especieRepository;
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private NaveRepository naveRepository;
    @Autowired
    private PersonagemRepository personagemRepository;
    @Autowired
    private PlanetaRepository planetaRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;

    public void exemplo(){
        Planeta planeta = new Planeta("Arid","Tatooine","1 standard",200000,new ArrayList<>(),new ArrayList<>());
        planetaRepository.save(planeta);
        Filme filme = new Filme("The Empire Strikes Back",5,"Filme Teste","Irvin Kershner","Gary Kurtz, Rick McCallum",
                LocalDate.of(1980,07,15), new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        filmeRepository.save(filme);
        Especie especie = new Especie("Humano","Galactic Basic",planeta,new ArrayList<>(),new ArrayList<>());
        especieRepository.save(especie);
        Veiculo veiculo = new Veiculo("Snowspeeder","t-47 airspeeder","airspeeder","Incom corporation",
                "4.5","10",650,new ArrayList<>(), new ArrayList<>());
        veiculoRepository.save(veiculo);
        Nave nave = new Nave("X-wing","T-65 X-wing","Starfighter","Incom Corporation","12.5","110",1050,
                new ArrayList<>(),new ArrayList<>());
        naveRepository.save(nave);
        List<Filme> filmes = new ArrayList<>();
        filmes.add(filme);
        List<Nave> naves = new ArrayList<>();
        naves.add(nave);
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(veiculo);

        Personagem personage=  new Personagem("Luke Skywalker",172,77,"male",1900,especie,planeta,filmes,naves,veiculos);

        personage.setId(1);
        personagemRepository.save(personage);
    }

}
