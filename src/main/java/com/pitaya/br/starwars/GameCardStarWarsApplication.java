package com.pitaya.br.starwars;


import com.pitaya.br.starwars.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameCardStarWarsApplication {

    @Autowired
    static PersonagemRepository personagemRepository;

	public static void main(String[] args) {
		SpringApplication.run(GameCardStarWarsApplication.class, args);

	}

}
