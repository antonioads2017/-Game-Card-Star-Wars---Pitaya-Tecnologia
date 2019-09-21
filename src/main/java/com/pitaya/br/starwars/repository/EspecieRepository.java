package com.pitaya.br.starwars.repository;

import com.pitaya.br.starwars.model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie,Integer> {
}
