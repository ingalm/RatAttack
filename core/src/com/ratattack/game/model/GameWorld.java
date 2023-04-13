package com.ratattack.game.model;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.SpriteComponent;
import com.ratattack.game.model.components.PowerUpComponent;
import com.ratattack.game.model.components.StrengthComponent;
import com.ratattack.game.model.components.UserComponent;
import com.ratattack.game.model.components.VelocityComponent;

public class GameWorld {
    // add listeners

    final PooledEngine engine;

    public GameWorld(PooledEngine engine) {
        this.engine = engine;
    }

    public Entity createUser() {
        Entity userEntity = new Entity();
        userEntity.add(new UserComponent());
        engine.addEntity(userEntity);
        return userEntity;
    }

    public Entity createBullet() {
        Entity bulletEntity = new Entity();
        bulletEntity.add(new PositionComponent());
        bulletEntity.add(new VelocityComponent());
        bulletEntity.add(new SpriteComponent());
        //bulletEntity.add(new PowerUpComponent());
        bulletEntity.add(new StrengthComponent());
        engine.addEntity(bulletEntity);
        return bulletEntity;
    }

}
