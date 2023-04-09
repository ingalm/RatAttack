package com.ratattack.game.model;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.SpriteComponent;
import com.ratattack.game.model.components.UpgradeComponent;
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

    public Entity createGrandmother() {
        Entity grandmotherEntity = new Entity();
        grandmotherEntity.add(new PositionComponent());
        grandmotherEntity.add(new SpriteComponent());
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

    public void createRat() {
        Entity ratEntity = new Entity();
        ratEntity.add(new SpriteComponent());
        ratEntity.add((new VelocityComponent()));
        ratEntity.add(new PositionComponent());

        Texture texture = new Texture("rat.png");
        ratEntity.getComponent(SpriteComponent.class).sprite = new Sprite(texture);

        PositionComponent position = ratEntity.getComponent(PositionComponent.class);
        position.x = 100;
        position.y = 1000;

        VelocityComponent velocity = ratEntity.getComponent(VelocityComponent.class);
        velocity.x = 0;
        velocity.y = -5;

        engine.addEntity(ratEntity);
    }

    public Entity createGrandchild() {
        Entity grandChildEntity = new Entity();
        grandChildEntity.add(new SpriteComponent());
        grandChildEntity.add((new VelocityComponent()));
        grandChildEntity.add(new PositionComponent());
        engine.addEntity(grandChildEntity);
        return grandChildEntity;
    }

}
