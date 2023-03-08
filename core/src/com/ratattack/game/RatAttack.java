package com.ratattack.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ratattack.game.gamecontroller.*;
import com.ratattack.game.screens.*;

public class RatAttack extends Game {
	SpriteBatch batch;
	Texture img;

	//Dette skal egentlig flyttes til controller, men vet ikke helt hvordan enda. Må tenkes på rundt state pattern og update().
	//private GameScreen gameScreen;
	//private MenuScreen menuScreen;
	//private OptionsScreen optionsScreen;
	//private TutorialScreen tutorialScreen;

	GameController gameController;
	
	@Override
	public void create () {
		gameController = new GameController(this);

		gameController.setStartScreen();

		batch = new SpriteBatch();
		img = new Texture("rats.jpg");
	}


	/* Eksempel på en Screen:

	public class GameScreen implements Screen{

    private MainClass mainClass;

    public GameScreen(MainClass mc)
    {
        mainClass=mc;
    }
    // your methods (show,render, pause, etc)
}

Now when you want to change the screen just use in your screen

mainClass.setMenuScreen();
	 */

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

		//Slett alt over etter hvert og kall på update i GameController
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
}
