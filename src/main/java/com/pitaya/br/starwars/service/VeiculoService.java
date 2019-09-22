package com.pitaya.br.starwars.service;

import com.pitaya.br.starwars.error.ResourceNotFoundException;
import com.pitaya.br.starwars.model.DTOs.NaveDTO;
import com.pitaya.br.starwars.model.DTOs.VeiculoDTO;
import com.pitaya.br.starwars.model.Filme;
import com.pitaya.br.starwars.model.Nave;
import com.pitaya.br.starwars.model.Personagem;
import com.pitaya.br.starwars.model.Veiculo;
import com.pitaya.br.starwars.repository.NaveRepository;
import com.pitaya.br.starwars.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private static final String PATH = "http://localhost:8090";

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoDTO getVeiculo(Integer id){
        Veiculo veiculo = veiculoRepository.findById(id).get();
        if(veiculo!=null){
            VeiculoDTO veiculoDTO = new VeiculoDTO();
            veiculoDTO.setId(veiculo.getId());
            veiculoDTO.setNome(veiculo.getNome());
            veiculoDTO.setModelo(veiculo.getModelo());
            veiculoDTO.setClasseNave(veiculo.getClasseNave());
            veiculoDTO.setFabricante(veiculo.getFabricante());
            veiculoDTO.setTamanho(veiculo.getTamanho());
            veiculoDTO.setCapacidadeDeCarga(veiculo.getCapacidadeDeCarga());
            veiculoDTO.setVelocidadeMaxima(veiculo.getVelocidadeMaxima());
            List<String> pilotos = new ArrayList<>();
            List<String> filmes = new ArrayList<>();

            for(Personagem personagem: veiculo.getPilotos()){
                String string = PATH+"/personagem/"+personagem.getId();
                pilotos.add(string);
            }
            for(Filme filme:veiculo.getFilmes()){
                String string = PATH+"/filme/"+filme.getId();
                filmes.add(string);
            }
            veiculoDTO.setPilotos(pilotos);
            veiculoDTO.setFilmes(filmes);

            return veiculoDTO;
        }else{
            throw new ResourceNotFoundException("Nave não encontrada");
        }
    }

    public List<VeiculoDTO> listar(){
        List<Veiculo> veiculos = veiculoRepository.findAll();
        List<VeiculoDTO> veiculoDTOS = new ArrayList<>();
        for(Veiculo veiculo:veiculos){
            veiculoDTOS.add(getVeiculo(veiculo.getId()));
        }
        return veiculoDTOS;
    }

    public void salvar(Veiculo veiculo){
        if(veiculoRepository.findById(veiculo.getId())==null){
            veiculoRepository.save(veiculo);
        }
    }

    public void atualizar(Veiculo veiculo){
        if(veiculoRepository.findById(veiculo.getId())!=null){
            veiculoRepository.save(veiculo);
        }else{
            throw new ResourceNotFoundException("Nave não encotrada");
        }
    }

    public void excluir (Integer id){
        if(veiculoRepository.findById(id)!=null){
            Optional<Veiculo> veiculo = veiculoRepository.findById(id);
            veiculoRepository.delete(veiculo.get());
        }else{
            throw  new ResourceNotFoundException("Nave não encontrada");
        }
    }
}
