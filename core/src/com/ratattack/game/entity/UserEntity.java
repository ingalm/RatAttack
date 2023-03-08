package com.ratattack.game.entity;

import com.badlogic.ashley.core.Entity;
import com.ratattack.game.entity.components.CurrencyComponent;
import com.ratattack.game.entity.components.HighscoreComponent;

public class UserEntity extends Entity{

    private Entity entity;

    public Entity createUser(String name, boolean multiplayer) {
        entity = new Entity();
        entity.add(new HighscoreComponent());
        entity.add(new CurrencyComponent());

        if(multiplayer){
            //do something - add networkservice here?
        } else {
            //do something else
        }

        return entity;
    }

}
