package com.pitaya.br.starwars.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Especie {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String linguagem;

    @OneToOne
    private Planeta planeta;

    @OneToMany(mappedBy = "especie")
    private List<Personagem> personagems;

    @ManyToMany(mappedBy = "especies")
    private List<Filme> filmes;

    public Especie() {
    }

    public Especie(String nome, String linguagem, Planeta planeta, List<Personagem> personagems, List<Filme> filmes) {
        this.nome = nome;
        this.linguagem = linguagem;
        this.planeta = planeta;
        this.personagems = personagems;
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

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public List<Personagem> getPersonagems() {
        return personagems;
    }

    public void setPersonagems(List<Personagem> personagems) {
        this.personagems = personagems;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
