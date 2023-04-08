package com.ratattack.game.model.entity.system;

import static com.ratattack.game.model.ComponentMappers.positionMapper;
import static com.ratattack.game.model.ComponentMappers.spriteMapper;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ratattack.game.model.entity.components.PositionComponent;
import com.ratattack.game.model.entity.components.SpriteComponent;

public class RenderSystem extends IteratingSystem {

    private static final Family renderFamily= Family.all(SpriteComponent.class, PositionComponent.class).get();
    private final SpriteBatch batch;


    public RenderSystem(SpriteBatch batch) {
        super(renderFamily);
        this.batch = batch;
    }

    @Override
    public void update(float deltaTime) {
        batch.begin();
        super.update(deltaTime);
        batch.end();
    }
    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        SpriteComponent spriteComponent = spriteMapper.get(entity);
        PositionComponent positionComponent = positionMapper.get(entity);

        Texture texture = spriteComponent.sprite.getTexture();

        batch.draw(texture, positionComponent.x, positionComponent.y);
    }
}
