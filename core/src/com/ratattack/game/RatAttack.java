package com.ratattack.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ratattack.game.gamecontroller.*;

public class RatAttack extends Game {
	Texture img;

	GameController gameController;
	
	@Override
	public void create () {
		gameController = GameController.getInstance();
		gameController.setGame(this);
		gameController.setStartScreen();

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
		gameController.getShapeRenderer().dispose();
		gameController.getStage().dispose();
		img.dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
}
