package com.ratattack.game.model.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.ratattack.game.model.entity.components.PositionComponent;
import com.ratattack.game.model.entity.components.VelocityComponent;

public class MovementSystem extends IteratingSystem {

    // det kan være UpgradeComponent også skal plasseres her
    private static final Family movementComponentFamily = Family.all(VelocityComponent.class, PositionComponent.class).get();
    private ComponentMapper<VelocityComponent> velocityMapper;
    private ComponentMapper<PositionComponent> positionMapper;

    //ikke en fullført klasse
    public MovementSystem() {
        super(movementComponentFamily);
        velocityMapper = ComponentMapper.getFor(VelocityComponent.class);
        positionMapper = ComponentMapper.getFor(PositionComponent.class);
    }

    // en update funksjon, så oppdatere posisjon?
    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }

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

    public int getPositonX(Entity entity) {
        return positionMapper.get(entity).x;
    }

    public int getPositonY(Entity entity) {
        return positionMapper.get(entity).y;
    }
}
