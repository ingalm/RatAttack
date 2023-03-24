package com.ratattack.game.model.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ratattack.game.model.entity.components.PositionComponent;
import com.ratattack.game.model.entity.components.SpriteComponent;

public class GrandmotherSystem extends IteratingSystem {

    private static final Family grandmotherComponentFamily = Family.all(
            PositionComponent.class, SpriteComponent.class).get();
    private ComponentMapper<PositionComponent> positionMapper;
    private ComponentMapper<SpriteComponent> spriteMapper;

    public GrandmotherSystem() {
        super(grandmotherComponentFamily);
        positionMapper = ComponentMapper.getFor(PositionComponent.class);
        spriteMapper = ComponentMapper.getFor(SpriteComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent positionComponent = positionMapper.get(entity);
        SpriteComponent spriteComponent = spriteMapper.get(entity);
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
