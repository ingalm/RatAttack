package com.ratattack.game.gamecontroller;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.PooledEngine;

public class GameEntityListener implements EntityListener {

    private static PooledEngine engine;

    public GameEntityListener(PooledEngine engine) {
        GameEntityListener.engine = engine;
        //Henter bestemødrene
    }

    @Override
    public void entityAdded(Entity entity) {
        //System.out.println("Entity added");
        /*if (Family.all(BoundsComponent.class).matches(entity)) {
            entities = engine.getEntitiesFor(Family.all(BoundsComponent.class).get());
        }*/
    }

    @Override
    public void entityRemoved(Entity entity) {
        //System.out.println("Entity removed");
        /*if (Family.all(BoundsComponent.class).matches(entity)) {
            entities = engine.getEntitiesFor(Family.all(BoundsComponent.class).get());
        }*/
    }
}
