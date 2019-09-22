package com.pitaya.br.starwars.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Filme {

    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private Integer episodio;
    private String descricao;
    private String diretor;
    private String producao;
    @Column(name="dataDeLancamento",columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeLancamento;

    @ManyToMany(mappedBy = "filmes")
    private List<Personagem> personagems;

    @ManyToMany
    @JoinTable(name = "filmePlaneta",
              joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "planeta_id"))
    private List<Planeta> planetas;

    @ManyToMany
    @JoinTable(name = "filmeNave",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "nave_id"))
    private List<Nave> naves;

    @ManyToMany
    @JoinTable(name = "filmePlaneta",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "veiculo_id"))
    private List<Veiculo> veiculos;

    @ManyToMany
    @JoinTable(name = "filmePlaneta",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "especie_id"))
    private List<Especie> especies;

    public Filme() {
    }

    public Filme(String titulo, Integer episodio, String descricao, String diretor,
                 String producao, LocalDate dataDeLancamento, List<Personagem> personagems,
                 List<Planeta> planetas, List<Nave> naves, List<Veiculo> veiculos, List<Especie> especies) {
        this.id = id;
        this.titulo = titulo;
        this.episodio = episodio;
        this.descricao = descricao;
        this.diretor = diretor;
        this.producao = producao;
        this.dataDeLancamento = dataDeLancamento;
        this.personagems = personagems;
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

    public List<Personagem> getPersonagems() {
        return personagems;
    }

    public void setPersonagems(List<Personagem> personagems) {
        this.personagems = personagems;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
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

    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }
}
