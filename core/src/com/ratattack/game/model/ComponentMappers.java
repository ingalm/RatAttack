package com.ratattack.game.model;

import com.badlogic.ashley.core.ComponentMapper;
import com.ratattack.game.model.entity.components.PositionComponent;
import com.ratattack.game.model.entity.components.SpriteComponent;
import com.ratattack.game.model.entity.components.UpgradeComponent;
import com.ratattack.game.model.entity.components.UserComponent;
import com.ratattack.game.model.entity.components.VelocityComponent;

public abstract class ComponentMappers {

    public static final ComponentMapper<PositionComponent> positionMapper = ComponentMapper.getFor(PositionComponent.class);
    public static final ComponentMapper<VelocityComponent> velocityMapper = ComponentMapper.getFor(VelocityComponent.class);
    public static final ComponentMapper<SpriteComponent> spriteMapper = ComponentMapper.getFor(SpriteComponent.class);
    public static final ComponentMapper<UpgradeComponent> upgradeMapper = ComponentMapper.getFor(UpgradeComponent.class);
    public static final ComponentMapper<UserComponent> userMapper = ComponentMapper.getFor(UserComponent.class);
}
