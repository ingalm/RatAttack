package com.ratattack.game.model.components;

import com.badlogic.ashley.core.Component;

public class BulletEffectComponent implements Component {
    // her skal powerup funskjonalitet legges til idk


    String effect;

    public BulletEffectComponent(String effect) {
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
