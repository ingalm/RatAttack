package com.ratattack.game.model.entity.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.ratattack.game.model.entity.components.PositionComponent;
import com.ratattack.game.model.entity.components.VelocityComponent;

public class RenderSystem extends IteratingSystem {

    // denne brukes ikke foreløpig, men kan brukes for å tegne og oppdatere entitetene
    // default family (må ta inn noe med tegning om den skal brukes - som betyr nye components)
    public RenderSystem(Family family) {
        super(family);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
