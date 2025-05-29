package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;
    public GameListDTO(){


    }
    // Quero receber um cosntrutor que receba a entitidade E NÃO OS ATRIBUTOS SEPARADOS
    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    
}
