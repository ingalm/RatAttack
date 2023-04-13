package com.ratattack.game.model.shootingStrategy;

import java.util.ArrayList;

public interface ShootingStrategy {

    ShootingStrategy[] strategies = {new NormalBulletStrategy(), new BigBulletStrategy(), new FastBulletStrategy(), new FreezeBulletStrategy(), new TripleBulletStrategy()};

    void shoot();
}
