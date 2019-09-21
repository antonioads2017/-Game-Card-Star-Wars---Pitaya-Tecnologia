package com.pitaya.br.starwars.repository;

import com.pitaya.br.starwars.model.Nave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaveRepository extends JpaRepository<Nave,Integer> {
}
