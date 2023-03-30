package com.ratattack.game.model;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.ratattack.game.model.entity.components.PositionComponent;
import com.ratattack.game.model.entity.components.SpriteComponent;
import com.ratattack.game.model.entity.components.UpgradeComponent;
import com.ratattack.game.model.entity.components.UserComponent;
import com.ratattack.game.model.entity.components.VelocityComponent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
        return userEntity;
    }

    public Entity createGrandmother() {
        Entity grandmotherEntity = new Entity();
        grandmotherEntity.add(new PositionComponent());
        grandmotherEntity.add(new SpriteComponent());
        engine.addEntity(grandmotherEntity);
        return grandmotherEntity;
    }

    public Entity createBullet() throws IOException {
        Entity bulletEntity = new Entity();
        bulletEntity.add(new PositionComponent());
        bulletEntity.add(new VelocityComponent());
        BufferedImage image = ImageIO.read(new File("bullet.png"));
        SpriteComponent sprite = new SpriteComponent();
        sprite.setImage(image);
        bulletEntity.add(sprite);
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

    public Entity createGrandchild() {
        Entity grandChildEntity = new Entity();
        grandChildEntity.add(new SpriteComponent());
        grandChildEntity.add((new VelocityComponent()));
        grandChildEntity.add(new PositionComponent());
        engine.addEntity(grandChildEntity);
        return grandChildEntity;
    }

}
