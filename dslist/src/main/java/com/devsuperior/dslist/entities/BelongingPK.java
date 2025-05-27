package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
// Temos 1 tipo representando dois campos e eu vou colocar esse tipo como sendo atributo como sendo outro tipo
// Eu to encapsulando 2 atributos em umclasse só
public class BelongingPK {
    // Vai ser mapeados dois campos la na 
    // Muitos para UM
    @ManyToOne
    // Nome da chave estrangeira
    @JoinColumn(name="game_id")
    private Game game;
    // Nome da chave estrangeira
    @ManyToOne
    @JoinColumn(name="list_id")
    private GameList list;

    public BelongingPK(){

    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }


    // Como sao duas chaves primarias que correspondem a uma tabela, tem que selecionar todos
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((game == null) ? 0 : game.hashCode());
        result = prime * result + ((list == null) ? 0 : list.hashCode());
        return result;
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        if (list == null) {
            if (other.list != null)
                return false;
        } else if (!list.equals(other.list))
            return false;
        return true;
    }

    

}
