package com.pitaya.br.starwars.model.DTOs;

import java.util.List;

public class VeiculoDTO {

    private Integer id;
    private String nome;
    private String modelo;
    private String classeNave;
    private String fabricante;
    private String tamanho;
    private String capacidadeDeCarga;
    private Integer velocidadeMaxima;

    private List<String> pilotos;
    private List<String> filmes;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Integer id, String nome, String modelo, String classeNave, String fabricante, String tamanho, String capacidadeDeCarga, Integer velocidadeMaxima, List<String> pilotos, List<String> filmes) {
        this.id = id;
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

    public List<String> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<String> pilotos) {
        this.pilotos = pilotos;
    }

    public List<String> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<String> filmes) {
        this.filmes = filmes;
    }
}
