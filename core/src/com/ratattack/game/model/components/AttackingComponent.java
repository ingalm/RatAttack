package com.ratattack.game.model.components;

import com.badlogic.ashley.core.Component;
import com.ratattack.game.model.shootingStrategy.NormalBulletStrategy;
import com.ratattack.game.model.shootingStrategy.ShootingStrategy;

public class AttackingComponent implements Component {

    private ShootingStrategy strategy;

    public AttackingComponent(NormalBulletStrategy normalBulletStrategy) {
        strategy = normalBulletStrategy;
    }

    public void setStrategy(ShootingStrategy newStrategy) {
        strategy = newStrategy;
    }

    public ShootingStrategy getStrategy() {return strategy;}
}
