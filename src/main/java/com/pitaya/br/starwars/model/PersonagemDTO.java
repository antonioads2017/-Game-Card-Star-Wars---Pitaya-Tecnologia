package com.pitaya.br.starwars.model;

import java.util.List;

public class PersonagemDTO {

    private Integer id;
    private String nome;
    private Integer altura;
    private Integer peso;
    private String sexo;
    private Integer anoDeNascimento;

    private String especie;
    private String planeta;

    private List<String> filmes;
    private List<String> veiculos;
    private List<String> naves;

    public PersonagemDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(Integer anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public List<String> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<String> filmes) {
        this.filmes = filmes;
    }

    public List<String> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<String> veiculos) {
        this.veiculos = veiculos;
    }

    public List<String> getNaves() {
        return naves;
    }

    public void setNaves(List<String> naves) {
        this.naves = naves;
    }
}
