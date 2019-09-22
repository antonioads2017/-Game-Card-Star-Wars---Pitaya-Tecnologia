package com.pitaya.br.starwars.model.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class FilmeDTO {

    private Integer id;
    private String titulo;
    private Integer episodio;
    private String descricao;
    private String diretor;
    private String producao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeLancamento;

    private List<String> personagens;
    private List<String> planetas;
    private List<String> naves;
    private List<String> veiculos;
    private List<String> especies;

    public FilmeDTO() {
    }

    public FilmeDTO(Integer id, String titulo, Integer episodio, String descricao, String diretor, String producao, LocalDate dataDeLancamento, List<String> personagens, List<String> planetas, List<String> naves, List<String> veiculos, List<String> especies) {
        this.id = id;
        this.titulo = titulo;
        this.episodio = episodio;
        this.descricao = descricao;
        this.diretor = diretor;
        this.producao = producao;
        this.dataDeLancamento = dataDeLancamento;
        this.personagens = personagens;
        this.planetas = planetas;
        this.naves = naves;
        this.veiculos = veiculos;
        this.especies = especies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Integer episodio) {
        this.episodio = episodio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getProducao() {
        return producao;
    }

    public void setProducao(String producao) {
        this.producao = producao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public List<String> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<String> planetas) {
        this.planetas = planetas;
    }

    public List<String> getNaves() {
        return naves;
    }

    public void setNaves(List<String> naves) {
        this.naves = naves;
    }

    public List<String> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<String> veiculos) {
        this.veiculos = veiculos;
    }

    public List<String> getEspecies() {
        return especies;
    }

    public void setEspecies(List<String> especies) {
        this.especies = especies;
    }
}
