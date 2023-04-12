package com.ratattack.game.model.system;

import static com.ratattack.game.model.ComponentMappers.positionMapper;
import static com.ratattack.game.model.ComponentMappers.spriteMapper;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.ratattack.game.model.components.BoundsComponent;
import com.ratattack.game.model.components.CircleBoundsComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.RectangleBoundsComponent;
import com.ratattack.game.model.components.SpriteComponent;

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
        BoundsComponent bounds = entity.getComponent(CircleBoundsComponent.class);
        if (bounds == null) {
            bounds = entity.getComponent(RectangleBoundsComponent.class);
        }
        PositionComponent position = positionMapper.get(entity);
        SpriteComponent spriteComponent = spriteMapper.get(entity);

        if(bounds != null) {
            int spriteWidth = spriteComponent.sprite.getTexture().getWidth();
            int spriteHeight = spriteComponent.sprite.getTexture().getHeight();
            bounds.setCenter(position.x + (spriteWidth/2), position.y + (spriteHeight/2));
        }
    }
}
