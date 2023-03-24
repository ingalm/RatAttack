package com.ratattack.game.model;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.PooledEngine;
import com.ratattack.game.model.entity.components.PositionComponent;
import com.ratattack.game.model.entity.components.SpriteComponent;
import com.ratattack.game.model.entity.components.UpgradeComponent;
import com.ratattack.game.model.entity.components.UserComponent;
import com.ratattack.game.model.entity.components.VelocityComponent;
import com.ratattack.game.model.entity.system.UserSystem;

public class GameWorld {
    // add listeners

    final PooledEngine engine;
    /*
    private final EntityListener entityListener = new EntityListener() {
        @Override
        public void entityAdded(Entity entity) {
        }

        @Override
        public void entityRemoved(Entity entity) {
        }
    };
*/
    public GameWorld(PooledEngine engine) {
        this.engine = engine;
    }

    public Entity createUser() {
        Entity userEntity = new Entity();
        userEntity.add(new UserComponent());
        engine.addEntity(userEntity);

        // dette er bare en test
        engine.getSystem(UserSystem.class).setUsername(userEntity, "SATAN");

        return userEntity;
    }

    public Entity createGrandmother() {
        Entity grandmotherEntity = new Entity();
        grandmotherEntity.add(new PositionComponent());
        grandmotherEntity.add(new SpriteComponent());
        //usikker på om denne hører til her eller i bullet
        grandmotherEntity.add(new UpgradeComponent());
        engine.addEntity(grandmotherEntity);

        return grandmotherEntity;
    }

    public Entity createBullet() {
        Entity bulletEntity = new Entity();
        bulletEntity.add(new PositionComponent());
        bulletEntity.add(new VelocityComponent());
        bulletEntity.add(new SpriteComponent());
        bulletEntity.add(new UpgradeComponent());
        engine.addEntity(bulletEntity);

        return bulletEntity;
    }

    public Entity createRat() {
        Entity ratEntity = new Entity();
        ratEntity.add(new SpriteComponent());
        ratEntity.add((new VelocityComponent()));
        ratEntity.add(new PositionComponent());

        engine.addEntity(ratEntity);
        return ratEntity;
    }

}
