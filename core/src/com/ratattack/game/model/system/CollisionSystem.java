package com.ratattack.game.model.system;

import static com.ratattack.game.model.ComponentMappers.circleBoundsMapper;
import static com.ratattack.game.model.ComponentMappers.positionMapper;
import static com.ratattack.game.model.ComponentMappers.rectangleBoundsMapper;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ratattack.game.model.components.BoundsComponent;
import com.ratattack.game.model.components.CircleBoundsComponent;
import com.ratattack.game.model.components.HealthComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.StrengthComponent;


public class CollisionSystem extends IteratingSystem {

    PooledEngine engine;

    private static final Family hittableEntitiesFamily = Family.all(HealthComponent.class).get();
    private static final Family bulletEntitiesFamily = Family.all(CircleBoundsComponent.class).get();

    public CollisionSystem() {
        super(bulletEntitiesFamily);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        if (entity.isScheduledForRemoval()) return;

        BoundsComponent bounds = circleBoundsMapper.get(entity); //Skal byttes til circlebounds når vi bare ser på bullets

        ImmutableArray<Entity> hittableEntities = getEngine().getEntitiesFor(hittableEntitiesFamily);

        if (bounds == null) return;

        for (Entity hittableEntity : hittableEntities) {
            if (hittableEntity.isScheduledForRemoval()) continue;

            //Get the other entity´s bounds
            BoundsComponent otherBounds = rectangleBoundsMapper.get(hittableEntity);

            if (otherBounds == null) continue;

            if (bounds.overlaps(otherBounds)) {

                //Håndtere misting av liv

                getEngine().removeEntity(hittableEntity);

            }
        }
    }
}
