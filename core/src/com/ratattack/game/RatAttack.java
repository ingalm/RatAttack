package com.ratattack.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ratattack.game.gamecontroller.*;
import com.ratattack.game.screens.*;

public class RatAttack extends Game {
	Texture img;

	//FIREBASE
	FirebaseInterface _FBIC;
	DataHolderClass dataHolder;

	public RatAttack(FirebaseInterface FBIC) {
		_FBIC = FBIC;
	}


	//Dette skal egentlig flyttes til controller, men vet ikke helt hvordan enda. Må tenkes på rundt state pattern og update().
	//private GameScreen gameScreen;
	//private MenuScreen menuScreen;
	//private OptionsScreen optionsScreen;
	//private TutorialScreen tutorialScreen;

	GameController gameController;
	
	@Override
	public void create () {
		gameController = new GameController();
		new ScoreManager();


		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		//FIREBASE
		dataHolder = new DataHolderClass();
		_FBIC.someFunction();
		_FBIC.firebaseTest();
		_FBIC.setOnValueChangedListener(dataHolder);
		_FBIC.setValueInDb("melding2", "Ny verdi har blitt gitt nå");

	}

		img = new Texture("rats.png");
	}

	@Override
	public void render () {
		//ScreenUtils.clear(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		gameController.update();

	}
	
	@Override
	public void dispose () {
		gameController.getBatch().dispose();
		img.dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
}
