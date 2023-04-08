package com.ratattack.game.screens;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;
import com.ratattack.game.gamecontroller.GameController;
import com.ratattack.game.model.GameWorld;
import com.ratattack.game.model.entity.system.BulletSystem;
import com.ratattack.game.model.entity.system.GrandchildSystem;
import com.ratattack.game.model.entity.system.GrandmotherSystem;
import com.ratattack.game.model.entity.system.RatSystem;
import com.ratattack.game.model.entity.system.UserSystem;

public class MenuScreen implements Screen {

    GameController gameController;

    public MenuScreen(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
