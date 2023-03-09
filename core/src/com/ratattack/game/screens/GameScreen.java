package com.ratattack.game.screens;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ratattack.game.RatAttack;
import com.ratattack.game.model.GameWorld;
import com.ratattack.game.model.entity.system.UserSystem;

public class GameScreen implements Screen {

    private RatAttack game;
    private Stage stage;

    private Texture background;
    private Label informationText;

    private Entity userEntity;
    private UserSystem userSystem;

    // husk å endre til å ta inn gamecontroller istedet
    public GameScreen(RatAttack game) {

        super();
        this.game = game;

        setupAshley();

    }

    public void setupAshley() {

        PooledEngine engine = new PooledEngine();
        GameWorld ashleyWorld = new GameWorld(engine);

        // ADDS SYSTEMS TO THE ENGINE
        engine.addSystem(new UserSystem());

        // CREATE PLAYERS AND COURSE
        userEntity = ashleyWorld.createUser();

        userSystem = engine.getSystem(UserSystem.class);
        // game.screenFactory.setEngine(engine);

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resize'");
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pause'");
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

}
