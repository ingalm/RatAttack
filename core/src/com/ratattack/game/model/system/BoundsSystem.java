package com.ratattack.game.model.system;

import static com.ratattack.game.model.ComponentMappers.boundsMapper;
import static com.ratattack.game.model.ComponentMappers.positionMapper;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.ratattack.game.model.components.BoundsComponent;
import com.ratattack.game.model.components.CircleBoundsComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.RectangleBoundsComponent;

public class BoundsSystem extends IteratingSystem {

    private static final Family boundsFamily = Family.one(RectangleBoundsComponent.class, CircleBoundsComponent.class).get();


    public BoundsSystem() {
        super(boundsFamily);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        BoundsComponent circleBounds = entity.getComponent(CircleBoundsComponent.class);
        PositionComponent position = positionMapper.get(entity);

        if(circleBounds != null) {
            circleBounds.setCenter(position.x, position.y);
        }
    }
}
