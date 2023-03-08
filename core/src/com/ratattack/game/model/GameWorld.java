package com.ratattack.game.model;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.PooledEngine;

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

    public GameWorld(PooledEngine engine){
        this.engine = engine;
    }

}
