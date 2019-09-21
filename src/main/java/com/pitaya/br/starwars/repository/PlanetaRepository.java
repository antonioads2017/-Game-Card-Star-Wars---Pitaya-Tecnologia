package com.pitaya.br.starwars.repository;

import com.pitaya.br.starwars.model.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetaRepository extends JpaRepository<Planeta,Integer> {
}
