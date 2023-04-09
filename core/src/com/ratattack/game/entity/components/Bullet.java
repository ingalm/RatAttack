package com.ratattack.game.entity.components;

abstract class Bullet {
    IBulletBehavior bulletBehavior;

    public Bullet(IBulletBehavior bulletBehavior){
        this.bulletBehavior = bulletBehavior;
    }
    public void shoot() {
        bulletBehavior.shoot();
    }
    public void setBulletBehavior(IBulletBehavior bulletBehavior) {
        this.bulletBehavior = bulletBehavior;
    }
}
