package com.ratattack.game.model.system;

import static com.ratattack.game.model.ComponentMappers.positionMapper;
import static com.ratattack.game.model.ComponentMappers.rectangleBoundsMapper;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ratattack.game.model.components.BoundsComponent;
import com.ratattack.game.model.components.HealthComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.StrengthComponent;


public class CollisionSystem extends IteratingSystem {

    PooledEngine engine;

    private static final Family hittableEntitiesFamily = Family.all(HealthComponent.class).get();
    private static final Family bulletEntitiesFamily = Family.all(StrengthComponent.class).get();

    public CollisionSystem() {
        super(hittableEntitiesFamily);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        if (entity.isScheduledForRemoval()) return;

        PositionComponent position = positionMapper.get(entity);
        BoundsComponent bounds = rectangleBoundsMapper.get(entity); //Skal byttes til circlebounds når vi bare ser på bullets

        ImmutableArray<Entity> entities = getEngine().getEntitiesFor(hittableEntitiesFamily);

        if (bounds == null) return;

        for (Entity otherEntity : entities) {
            if (otherEntity.isScheduledForRemoval()) continue;

            //Get the other entity´s bounds
            BoundsComponent otherBounds = rectangleBoundsMapper.get(otherEntity);

            if (otherBounds == null) continue;

            if (bounds.overlaps(otherBounds)) {

                //Håndtere misting av liv

                getEngine().removeEntity(otherEntity);

                /*if (validEvent) {
                    notifyListeners(entity, other);
                    notifyListeners(other, entity);
                }*/
            }
        }

        /*// Check for collisions with other entities
        for (Entity otherEntity : getEntities()) {
            if (otherEntity == entity) {
                continue;    // skip self
            }
            CollisionComponent otherCollision = ComponentMappers.cm.get(otherEntity);
            PositionComponent otherPosition = ComponentMappers.positionMapper.get(entity);

            if (position.x < otherPosition.x + otherCollision.width &&
                    position.x + collision.width > otherPosition.x &&
                    position.y < otherPosition.y + otherCollision.height &&
                    position.y + collision.height > otherPosition.y) {
                // Collision detected, handle accordingly
                System.out.println("baaam!");

                // Create a ComponentMapper for the component you're interested in
                ComponentMapper<CollisionComponent> collisionMapper = ComponentMapper.getFor(CollisionComponent.class);

                // Iterate over all entities with the CollisionComponent
                for (Entity checkEntity : engine.getEntitiesFor(Family.all(CollisionComponent.class).get())) {
                    // Check if the entity has the desired properties
                    PositionComponent positionComponent = ComponentMappers.positionMapper.get(checkEntity);
                    if (positionComponent.x == entity.getComponent(PositionComponent.class).x
                            && positionComponent.y == entity.getComponent(PositionComponent.class).y) {
                        // Do something with the entity
                        engine.removeEntity(entity);

                        System.out.println("Found entity with CollisionComponent at (100, 200)");
                    }
                }
            }
        }*/


    }
}
