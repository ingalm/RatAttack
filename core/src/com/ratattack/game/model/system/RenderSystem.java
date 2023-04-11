package com.ratattack.game.model.system;

import static com.ratattack.game.model.ComponentMappers.boundsMapper;
import static com.ratattack.game.model.ComponentMappers.positionMapper;
import static com.ratattack.game.model.ComponentMappers.spriteMapper;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.ratattack.game.gamecontroller.GameController;
import com.ratattack.game.model.components.BoundsComponent;
import com.ratattack.game.model.components.CircleBoundsComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.SpriteComponent;

public class RenderSystem extends IteratingSystem {

    private static final Family renderFamily = Family.all(SpriteComponent.class, PositionComponent.class).get();
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
        BoundsComponent boundsComponent = entity.getComponent(CircleBoundsComponent.class);
        //Legg inn å hente rectangleboundet her også

        if (boundsComponent != null) {
            ShapeRenderer renderer = new ShapeRenderer();
            renderer.begin(ShapeRenderer.ShapeType.Filled); // specify the shape type (Filled, Line, or Point)
            renderer.setColor(Color.RED); // set the color of the shape
            Shape2D shape = boundsComponent.getBounds();
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                renderer.circle(circle.x, circle.y, circle.radius); // draw the circle
            } else {
                Rectangle rectangle = (Rectangle) shape;
                renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height); // draw the rectangle
            }
            renderer.end(); // end the ShapeRenderer
        }

        Texture texture = spriteComponent.sprite.getTexture();

        batch.draw(texture, positionComponent.x, positionComponent.y);
    }
}
