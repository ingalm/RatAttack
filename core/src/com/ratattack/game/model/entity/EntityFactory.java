package com.ratattack.game.model.entity;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.ratattack.game.model.entity.components.UserComponent;

public class EntityFactory {

    PooledEngine engine;

    public EntityFactory(PooledEngine engine){
        this.engine = engine;
    }

    public Entity createUser() {
        Entity userEntity = new Entity();
        userEntity.add(new UserComponent());
        engine.addEntity(userEntity);
        return userEntity;
    }

}
