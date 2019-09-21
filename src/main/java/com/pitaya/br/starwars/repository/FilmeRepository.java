package com.pitaya.br.starwars.repository;

import com.pitaya.br.starwars.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme,Integer> {
}
