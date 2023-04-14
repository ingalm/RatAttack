package com.ratattack.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ratattack.game.DataHolderClass;
import com.ratattack.game.FirebaseInterface;
import com.ratattack.game.Highscore;
import com.ratattack.game.ScoreManager;
import com.ratattack.game.gamecontroller.GameController;

public class HighscoreScreen implements Screen {

    GameController gameController = GameController.getInstance();
    SpriteBatch batch2;

    Texture background = new Texture("bluebackground.png");
    int width = Gdx.graphics.getWidth();
    int height = Gdx.graphics.getHeight();
    DataHolderClass dataHolder;

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
        dataHolder = new DataHolderClass();
        stage = new Stage(new ScreenViewport());
        batch2 = new SpriteBatch();
        gameController = GameController.getInstance();
        highscore = new Highscore(_FBIC);
        new ScoreManager();
        System.out.println("denne er fra MenuScreen" + dataHolder.getSomeValue());
        dataHolder.PrintSomeValue();
        highscore.submitHighscore("Rebecca", 780);
    }

    @Override
    public void render(float delta) {
        batch2.begin();
        batch2.draw(background, 0, 0, width, height);
        gameController.update();
        highscore.render(batch2);
        batch2.end();
        stage.draw();
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
