package com.pitaya.br.starwars.repository;

import com.pitaya.br.starwars.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem,Integer> {
}
