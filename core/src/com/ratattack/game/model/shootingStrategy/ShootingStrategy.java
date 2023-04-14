package com.ratattack.game.model.shootingStrategy;

import java.util.ArrayList;

public interface ShootingStrategy {

    ShootingStrategy[] strategies = {new NormalBulletStrategy(), new BigBulletStrategy(), new FastBulletStrategy(), new FreezeBulletStrategy(), new TripleBulletStrategy()};
    int[] prices = {100, 200, 300, 400, 500};

    void shoot(int x, int y);
}
