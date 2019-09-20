package com.pitaya.br.starwars.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Planeta {

    @GeneratedValue
    private Integer id;
    private String clima;
    private String nome;
    private String gravidade;
    private Integer populacao;

    @OneToOne
    @JoinColumn(name = "especie_id")
    private Especie especie;

    @OneToMany(mappedBy = "planeta")
    private List<Personagem> residentes;

    @ManyToMany(mappedBy = "planetas")
    private List<Filme> filmes;

    public Planeta() {
    }

    public Planeta(String clima, String nome, String gravidade, Integer populacao, List<Personagem> residentes, List<Filme> filmes) {
        this.clima = clima;
        this.nome = nome;
        this.gravidade = gravidade;
        this.populacao = populacao;
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

    public List<Personagem> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Personagem> residentes) {
        this.residentes = residentes;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
