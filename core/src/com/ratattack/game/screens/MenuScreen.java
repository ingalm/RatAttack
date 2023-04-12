package com.ratattack.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ratattack.game.gamecontroller.GameController;

public class MenuScreen implements Screen {


    /***
     * TODO: LEGG TIL KOMMENTARER
     * */


    GameController gameController = GameController.getInstance();


    private BitmapFont font;
    SpriteBatch batch = GameController.getInstance().getBatch();

    Texture background = new Texture("bluebackground.png");
    Texture pinkButton = new Texture("pinkbutton.png");
    Texture purpleButton = new Texture("purplebutton.png");

    Texture purpleButton2 = new Texture("rat.png");
    int width = Gdx.graphics.getWidth();
    int height = Gdx.graphics.getHeight();

    private Stage stage;

    public MenuScreen() {

    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Button goToGameScreenB = makeButton(pinkButton,2f,"GAME");
        Button goToTutorialScreenB = makeButton(purpleButton,5f,"TUTORIAL");
        Button goToHighscoreScreenB = makeButton(purpleButton2, 20f, "HIGHSCORE");


        font = new BitmapFont();
        font.setColor(Color.RED);
        font.getData().setScale(10);

        stage.addActor(goToGameScreenB);
        stage.addActor(goToTutorialScreenB);
        stage.addActor(goToHighscoreScreenB);


    }



    @Override
    public void render(float delta) {


        batch.begin();
        batch.draw(background, 0, 0, width, height);
        font.draw(batch, "MENU SCREEN", 200, 200);
        batch.end();

        stage.draw();

    }

    private Button makeButton(Texture texture, float xPos, final String nextScreen){
        Button b = new Button(new TextureRegionDrawable(new TextureRegion(texture)));
        b.setSize(Gdx.graphics.getWidth()/10f  ,   Gdx.graphics.getHeight()/7f);
        b.setPosition(Gdx.graphics.getWidth() / xPos - b.getWidth()/2f,Gdx.graphics.getHeight() / 10f*3f - b.getHeight() / 2f);
        b.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent inputEvent, float xpos, float ypos) {
                //bytter screen vha state manager
                gameController.stateManager.changeScreen(nextScreen);
            }
        });
        return b;
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
        font.dispose();
        stage.dispose();
        batch.dispose();

    }
}
