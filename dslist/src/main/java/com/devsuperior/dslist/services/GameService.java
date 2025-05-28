package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    // criar metodo pra buscar por ID no API postman  http://localhost:8080/games/ID
    // Garanta que a transicao do banco de dados ACID, atomica, isolada e duravel
    // Transactional do spring , NAO DO JAKARTA
    @Transactional(readOnly=true)//Argumento que assegura nao vou fazer nenhuma operacao de escrita, entao nao vou bloquear meu banco de dados pra escrita
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get(); //retorna tipo opcional, use get()
        // converter um objeto Game pra um objeto GameDTO
        //Usa construtor
        GameDTO dto = new GameDTO(result);
        return dto;
        
    }

    // Chame o GameRepository , busca todo mundo no Banco de dados pelo FINDALL
    //devolva uma lista de objetos e converte cada objeto pra GameMinDTO que mostra os dados reduzidos apenas com 5 informacoes pra requisicao
    @Transactional(readOnly=true)//Argumento que assegura nao vou fazer nenhuma operacao de escrita, entao nao vou bloquear meu banco de dados pra escrita----- agora ir no controlador
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        // OPeraçao que transforma uma lista de Games em uma lista de GameMinDto
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    
    }
}
