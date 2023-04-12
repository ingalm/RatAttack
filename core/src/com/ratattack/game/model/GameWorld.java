package com.ratattack.game.model;

import static com.ratattack.game.model.ComponentMappers.positionMapper;
import static com.ratattack.game.model.ComponentMappers.rectangleBoundsMapper;
import static com.ratattack.game.model.ComponentMappers.spriteMapper;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ratattack.game.model.components.AttackingComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.RectangleBoundsComponent;
import com.ratattack.game.model.components.SpriteComponent;
import com.ratattack.game.model.components.PowerUpComponent;
import com.ratattack.game.model.components.StrengthComponent;
import com.ratattack.game.model.components.UserComponent;
import com.ratattack.game.model.components.VelocityComponent;
import com.ratattack.game.model.shootingStrategy.NormalBulletStrategy;

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

    public void createGrandmother(int x, int y) {
        Entity grandmotherEntity = new Entity();
        grandmotherEntity.add(new PositionComponent());
        grandmotherEntity.add(new SpriteComponent());
        grandmotherEntity.add(new AttackingComponent(new NormalBulletStrategy()));
        grandmotherEntity.add(new RectangleBoundsComponent());

        PositionComponent position = positionMapper.get(grandmotherEntity);
        position.x = x;
        position.y = y;

        SpriteComponent sprite = spriteMapper.get(grandmotherEntity);
        Texture texture = new Texture("grandmother.png");
        sprite.sprite = new Sprite(texture);

        RectangleBoundsComponent bounds = rectangleBoundsMapper.get(grandmotherEntity);
        bounds.setCenter(position.x, position.y);
        bounds.setSize(texture.getWidth(), texture.getHeight());

        engine.addEntity(grandmotherEntity);
    }

    public Entity createBullet() {
        Entity bulletEntity = new Entity();
        bulletEntity.add(new PositionComponent());
        bulletEntity.add(new VelocityComponent());
        bulletEntity.add(new SpriteComponent());
        bulletEntity.add(new PowerUpComponent());
        bulletEntity.add(new StrengthComponent());
        engine.addEntity(bulletEntity);
        return bulletEntity;
    }

}
