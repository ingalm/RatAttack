package com.ratattack.game.model.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.TimeUtils;
import com.ratattack.game.gamecontroller.GameController;
import com.ratattack.game.model.components.BalanceComponent;
import com.ratattack.game.model.components.CollisionComponent;
import com.ratattack.game.model.components.HealthComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.SpriteComponent;
import com.ratattack.game.model.components.VelocityComponent;

import java.util.Random;

public class SpawnSystem extends IteratingSystem {
    private long lastRatSpawnTime;
    private long lastGrandChildSpawnTime;
    private final long ratSpawnInterval;
    private final long grandChildSpawnInterval;
    private final PooledEngine engine;

    public SpawnSystem(PooledEngine engine, long ratSpawnrate, long grandChildSpawnrate) {
        super(Family.all(SpriteComponent.class).get());
        this.ratSpawnInterval = ratSpawnrate;
        this.grandChildSpawnInterval = grandChildSpawnrate;
        lastRatSpawnTime = TimeUtils.millis();
        lastGrandChildSpawnTime = TimeUtils.millis();
        this.engine = engine;
    }

    @Override
    public void update(float deltaTime) {
        long currentTime = TimeUtils.millis();
        if (currentTime - lastRatSpawnTime >= ratSpawnInterval) {
            spawnRat();
            lastRatSpawnTime = currentTime;
        }
        if (currentTime - lastGrandChildSpawnTime >= grandChildSpawnInterval) {
            spawnGrandChild();
            lastGrandChildSpawnTime = currentTime;
        }
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }

    private void spawnRat() {
        Entity rat = new Entity();
        rat.add(new SpriteComponent());
        rat.add((new VelocityComponent()));
        rat.add(new PositionComponent());
        rat.add(new HealthComponent());
        rat.add(new CollisionComponent());

        Texture texture = new Texture("rat.png");
        rat.getComponent(SpriteComponent.class).sprite = new Sprite(texture);

        //Position is not randomized yet, should be added
        PositionComponent position = rat.getComponent(PositionComponent.class);
        position.x = 100;
        position.y = 1000;

        VelocityComponent velocity = rat.getComponent(VelocityComponent.class);
        Random random = new Random();
        int min = 1;
        int max = 10;
        int randomNumber = random.nextInt(max - min + 1) + min;

        velocity.x = 0;
        velocity.y = -randomNumber;

        CollisionComponent collision = rat.getComponent(CollisionComponent.class);
        collision.height = rat.getComponent(SpriteComponent.class).sprite.getTexture().getHeight();
        collision.width = rat.getComponent(SpriteComponent.class).sprite.getTexture().getWidth();

        engine.addEntity(rat);
    }

    private void spawnGrandChild() {
        Entity grandChildEntity = new Entity();
        //grandChildEntity.add(new SpriteComponent());
        grandChildEntity.add((new VelocityComponent()));
        grandChildEntity.add(new PositionComponent());
        grandChildEntity.add(new HealthComponent());
        grandChildEntity.add(new BalanceComponent());

        //Add position, velocity, health, balance and sprite

        engine.addEntity(grandChildEntity);
    }
}
