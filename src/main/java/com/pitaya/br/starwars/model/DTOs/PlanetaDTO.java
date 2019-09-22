package com.pitaya.br.starwars.model.DTOs;

import java.util.List;

public class PlanetaDTO {

    private Integer id;
    private String clima;
    private String nome;
    private String gravidade;
    private Integer populacao;

    private String especie;

    private List<String> residentes;
    private List<String> filmes;

    public PlanetaDTO() {
    }

    public PlanetaDTO(Integer id, String clima, String nome, String gravidade, Integer populacao, String especie, List<String> residentes, List<String> filmes) {
        this.id = id;
        this.clima = clima;
        this.nome = nome;
        this.gravidade = gravidade;
        this.populacao = populacao;
        this.especie = especie;
        this.residentes = residentes;
        this.filmes = filmes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public List<String> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<String> residentes) {
        this.residentes = residentes;
    }

    public List<String> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<String> filmes) {
        this.filmes = filmes;
    }
}
