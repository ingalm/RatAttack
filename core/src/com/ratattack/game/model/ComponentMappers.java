package com.ratattack.game.model;

import com.badlogic.ashley.core.ComponentMapper;
import com.ratattack.game.model.components.BoundsComponent;
import com.ratattack.game.model.components.CircleBoundsComponent;
import com.ratattack.game.model.components.CollisionComponent;
import com.ratattack.game.model.components.PositionComponent;
import com.ratattack.game.model.components.RectangleBoundsComponent;
import com.ratattack.game.model.components.SpriteComponent;
import com.ratattack.game.model.components.PowerUpComponent;
import com.ratattack.game.model.components.UserComponent;
import com.ratattack.game.model.components.VelocityComponent;

public abstract class ComponentMappers {

    public static final ComponentMapper<PositionComponent> positionMapper = ComponentMapper.getFor(PositionComponent.class);
    public static final ComponentMapper<VelocityComponent> velocityMapper = ComponentMapper.getFor(VelocityComponent.class);
    public static final ComponentMapper<SpriteComponent> spriteMapper = ComponentMapper.getFor(SpriteComponent.class);
    public static final ComponentMapper<PowerUpComponent> upgradeMapper = ComponentMapper.getFor(PowerUpComponent.class);
    public static final ComponentMapper<UserComponent> userMapper = ComponentMapper.getFor(UserComponent.class);
    public static final ComponentMapper<RectangleBoundsComponent> rectangleBoundsMapper = ComponentMapper.getFor(RectangleBoundsComponent.class);
    public static final ComponentMapper<CircleBoundsComponent> circleBoundsMapper = ComponentMapper.getFor(CircleBoundsComponent.class);
}
