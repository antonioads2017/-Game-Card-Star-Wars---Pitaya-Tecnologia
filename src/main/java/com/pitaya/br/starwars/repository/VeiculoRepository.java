package com.pitaya.br.starwars.repository;


import com.pitaya.br.starwars.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo,Integer> {
}
