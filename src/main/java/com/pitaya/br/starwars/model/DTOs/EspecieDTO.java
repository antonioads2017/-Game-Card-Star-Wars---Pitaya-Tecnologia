package com.pitaya.br.starwars.model.DTOs;

import java.util.List;

public class EspecieDTO {

    private Integer id;
    private String nome;
    private String linguagem;

    private String planeta;

    private List<String> personagens;
    private List<String> filmes;

    public EspecieDTO() {
    }

    public EspecieDTO(Integer id, String nome, String linguagem, String planeta, List<String> personagens, List<String> filmes) {
        this.id = id;
        this.nome = nome;
        this.linguagem = linguagem;
        this.planeta = planeta;
        this.personagens = personagens;
        this.filmes = filmes;
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

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public List<String> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<String> filmes) {
        this.filmes = filmes;
    }
}
