package com.pitaya.br.starwars.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Personagem {


    @GeneratedValue
    private Integer id;
    private String nome;
    private Integer altura;
    private Integer peso;
    private String sexo;
    private Integer anoDeNascimento;

    @ManyToOne
    @JoinColumn(name = "especie_id")
    private Especie especie;
    @ManyToOne
    @JoinColumn(name = "planeta_id")
    private Planeta planeta;

    @ManyToMany
    @JoinTable(name = "personagemFilme",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "filme_id"))
    private List<Filme> filmes;


    @ManyToMany
    @JoinTable(name = "personagemNave",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "nave_id"))
    private List<Nave> naves;

    @ManyToMany
    @JoinTable(name = "personagemVeiculo",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "veiculo_id"))
    private List<Veiculo> veiculos;

    public Personagem() {
    }

    public Personagem(String nome, Integer altura,
                      Integer peso, String sexo, Integer anoDeNascimento,
                      Especie especie, Planeta planeta, List<Filme> filmes, List<Nave> naves,
                      List<Veiculo> veiculos) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.anoDeNascimento = anoDeNascimento;
        this.especie = especie;
        this.planeta = planeta;
        this.filmes = filmes;
        this.naves = naves;
        this.veiculos = veiculos;
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

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void setNaves(List<Nave> naves) {
        this.naves = naves;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
