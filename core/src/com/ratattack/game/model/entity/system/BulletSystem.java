package com.ratattack.game.model.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ratattack.game.model.entity.components.PositionComponent;
import com.ratattack.game.model.entity.components.SpriteComponent;
import com.ratattack.game.model.entity.components.UpgradeComponent;
import com.ratattack.game.model.entity.components.VelocityComponent;

public class BulletSystem extends IteratingSystem {

    private static final Family bulletComponentFamily = Family.all(VelocityComponent.class,
            PositionComponent.class, SpriteComponent.class, UpgradeComponent.class).get();
    private ComponentMapper<VelocityComponent> velocityMapper;
    private ComponentMapper<PositionComponent> positionMapper;
    private ComponentMapper<SpriteComponent> spriteMapper;
    private ComponentMapper<UpgradeComponent> upgradeMapper;

    public BulletSystem() {
        super(bulletComponentFamily);
        velocityMapper = ComponentMapper.getFor(VelocityComponent.class);
        positionMapper = ComponentMapper.getFor(PositionComponent.class);
        spriteMapper = ComponentMapper.getFor(SpriteComponent.class);
        upgradeMapper = ComponentMapper.getFor(UpgradeComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        VelocityComponent velocityComponent = velocityMapper.get(entity);
        PositionComponent positionComponent = positionMapper.get(entity);
        SpriteComponent spriteComponent = spriteMapper.get(entity);
        UpgradeComponent upgradeComponent = upgradeMapper.get(entity);
    }
    //TODO: add methods for upgrade

    public void setVelocityX(Entity entity, int velX) {
        velocityMapper.get(entity).x = velX;
    }

    public void setVelocityY(Entity entity, int velY) {
        velocityMapper.get(entity).y = velY;
    }

    public int getVelocityX(Entity entity) {
        return velocityMapper.get(entity).x;
    }

    public int getVelocityY(Entity entity) {
        return velocityMapper.get(entity).y;
    }

    public void setPositionX(Entity entity, int posX) {
        positionMapper.get(entity).x = posX;
    }

    public void setPositionY(Entity entity, int posY) {
        positionMapper.get(entity).y = posY;
    }

    public int getPositionX(Entity entity) {
        return positionMapper.get(entity).x;
    }

    public int getPositionY(Entity entity) {
        return positionMapper.get(entity).y;
    }

    public void setSprite(Entity entity, Sprite sprite) {
        spriteMapper.get(entity).sprite = sprite;
    }

    public Sprite getSprite(Entity entity) {
        return spriteMapper.get(entity).sprite;
    }
}
