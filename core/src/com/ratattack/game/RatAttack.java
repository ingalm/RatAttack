package com.ratattack.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ratattack.game.gamecontroller.*;
import com.ratattack.game.screens.*;

public class RatAttack extends ApplicationAdapter {
	SpriteBatch batch;
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

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		//FIREBASE
		dataHolder = new DataHolderClass();
		_FBIC.someFunction();
		_FBIC.firebaseTest();
		_FBIC.setOnValueChangedListener(dataHolder);
		_FBIC.setValueInDb("melding2", "Ny verdi har blitt gitt nå");
		System.out.println("Her hentes value fra db" + dataHolder.getSomeValue());

	}

	/*
	setGameScreen()
	{
		gameScreen=new GameScreen(this);
		setScreen(gameScreen);
	}
	setMenuScreen()
	{
		menuScreen=new menuScreen(this);
		setScreen(menuScreen);
	}
	setOptionsScreen()
	{
		optionsScreen=new OptionsScreen(this);
		setScreen(optionsScreen);
	}
	setTutorialScreen() {
		tutorialScreen = new TutorialScreen(this);
		setScreen(tutorialScreen);
	}
	 */

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
}
