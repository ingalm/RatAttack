package com.ratattack.game.screens;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.ratattack.game.gamecontroller.GameController;

public class GameScreen implements Screen {

    private GameController gameController = GameController.getInstance();
    private PooledEngine engine = gameController.getEngine();

    private Texture background;
    private Texture textField;

    public GameScreen() {
        gameController.setUpGame();
        resume(); // Prøv å slette denne når det funker, kan være den spiller av fra start
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub

        gameController.field.draw();

        //throw new UnsupportedOperationException("Unimplemented method 'render'");
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'resize'");
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        gameController.pause();
        //throw new UnsupportedOperationException("Unimplemented method 'pause'");
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        gameController.play(); // Vet ikke om vi trenger dette. Vet ikke helt hva alle disse funksjonene gjøre enda, så sjekk det ut når man finner det ut
        //throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

}
