package com.ratattack.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Pool;
import com.ratattack.game.gamecontroller.GameController;
import com.ratattack.game.model.GameWorld;
import com.ratattack.game.model.entity.system.UserSystem;

import java.awt.Menu;

public class MenuScreen implements Screen {

    GameController gameController;

    private UserSystem userSystem;
    private Entity user;

    public MenuScreen(GameController gameController) {
        this.gameController = gameController;
        setUpAshley();
    }

    private void setUpAshley() {
        PooledEngine engine = new PooledEngine();
        GameWorld ashleyWorld = new GameWorld(engine);

        //Add systems to engine
        engine.addSystem(new UserSystem());

        //Create User
        user = ashleyWorld.createUser();

        userSystem = engine.getSystem(UserSystem.class);
        ScreenFactory.setEngine(engine);

        System.out.println(userSystem.getUsername(engine.getEntities().get(0)));
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
