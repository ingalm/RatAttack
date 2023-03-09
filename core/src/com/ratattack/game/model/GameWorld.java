package com.ratattack.game.model;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.PooledEngine;
import com.ratattack.game.model.entity.components.UserComponent;
import com.ratattack.game.model.entity.system.UserSystem;

public class GameWorld {
    // add listeners

    final PooledEngine engine;
    private final EntityListener entityListener = new EntityListener() {
        @Override
        public void entityAdded(Entity entity) {
        }

        @Override
        public void entityRemoved(Entity entity) {
        }
    };

    public GameWorld(PooledEngine engine) {
        this.engine = engine;
    }

    public Entity createUser() {
        Entity userOneEntity = new Entity();
        userOneEntity.add(new UserComponent());
        engine.addEntity(userOneEntity);

        engine.getSystem(UserSystem.class).setUsername(userOneEntity, "SATAN");

        return userOneEntity;
    }

}
