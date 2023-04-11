package com.ratattack.game.model.system;

import static com.ratattack.game.model.ComponentMappers.boundsMapper;
import static com.ratattack.game.model.ComponentMappers.positionMapper;
import static com.ratattack.game.model.ComponentMappers.velocityMapper;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.ratattack.game.model.components.BoundsComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.VelocityComponent;

public class MovementSystem extends IteratingSystem {

    private static final Family movementFamily = Family.all(VelocityComponent.class, PositionComponent.class).get();

    public MovementSystem() {
        super(movementFamily);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent positionComponent = positionMapper.get(entity);
        VelocityComponent velocityComponent = velocityMapper.get(entity);

        positionComponent.x += velocityComponent.x;
        positionComponent.y += velocityComponent.y;
    }
}
