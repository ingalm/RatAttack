package com.ratattack.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ratattack.game.FirebaseInterface;
import com.ratattack.game.Highscore;
import com.ratattack.game.ScoreManager;
import com.ratattack.game.gamecontroller.GameController;

public class HighscoreScreen implements Screen {

    GameController gameController = GameController.getInstance();
    SpriteBatch batch = GameController.getInstance().getBatch();

    Texture background = new Texture("bluebackground.png");
    int width = Gdx.graphics.getWidth();
    int height = Gdx.graphics.getHeight();

    private Stage stage;
    Highscore highscore;

    FirebaseInterface _FBIC;

    public HighscoreScreen(FirebaseInterface FBIC) {
        _FBIC = FBIC;
    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        highscore = new Highscore(_FBIC);
        new ScoreManager();

    }

    @Override
    public void render(float delta) {
        batch.begin();
        highscore.render(batch);
        batch.end();

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
