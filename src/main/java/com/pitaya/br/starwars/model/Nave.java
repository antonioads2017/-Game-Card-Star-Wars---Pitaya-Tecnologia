package com.pitaya.br.starwars.model;

import java.util.List;

public class Nave {

    private Integer id;
    private String nome;
    private String modelo;
    private String classeNave;
    private String fabricante;
    private String tamanho;
    private String capacidadeDeCarga;
    private Integer velocidadeMaxima;
    private List<Personagem> pilotos;
    private List<Filme> filmes;

    public Nave() {
    }

    public Nave(String nome, String modelo, String classeNave, String fabricante,
                String tamanho, String capacidadeDeCarga, Integer velocidadeMaxima,
                List<Personagem> pilotos, List<Filme> filmes) {
        this.nome = nome;
        this.modelo = modelo;
        this.classeNave = classeNave;
        this.fabricante = fabricante;
        this.tamanho = tamanho;
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.velocidadeMaxima = velocidadeMaxima;
        this.pilotos = pilotos;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getClasseNave() {
        return classeNave;
    }

    public void setClasseNave(String classeNave) {
        this.classeNave = classeNave;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public void setCapacidadeDeCarga(String capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Integer velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public List<Personagem> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Personagem> pilotos) {
        this.pilotos = pilotos;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
