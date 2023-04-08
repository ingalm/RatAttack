package com.ratattack.game.gamecontroller;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ratattack.game.RatAttack;
import com.ratattack.game.model.GameWorld;
import com.ratattack.game.model.entity.system.MovementSystem;
import com.ratattack.game.model.entity.system.RenderSystem;
import com.ratattack.game.model.entity.system.UserSystem;
import com.ratattack.game.screens.OptionScreen;
import com.ratattack.game.screens.ScreenFactory;
import com.ratattack.game.screens.TutorialScreen;

public class GameController {

    private static final GameController instance = new GameController();

    private ScreenFactory screenFactory;
    SpriteBatch batch;

    // Ashley
    RatAttack game;
    public static PooledEngine engine;

    private GameController() {
        batch = new SpriteBatch();
        setUpAshley();
    }

    public static GameController getInstance() {
        return instance;
    }

    public void setStartScreen() {
        setMenuScreen();
    }

    private void setGameScreen() {
        try {
            game.setScreen(ScreenFactory.getScreen("GAME"));
        } catch (Exception e) {
            System.out.println("No game instance set for the game controller");
        }
    }

    private void setMenuScreen() {
        try {
            game.setScreen(ScreenFactory.getScreen("MENU"));
        } catch (Exception e) {
            System.out.println("No game instance set for the game controller");
        }
    }

    private void setOptionsScreen() {
        OptionScreen optionScreen = new OptionScreen(this);
        game.setScreen(optionScreen);
    }

    private void setTutorialScreen() {
        TutorialScreen tutorialScreen = new TutorialScreen(this);
        game.setScreen(tutorialScreen);
    }

    private void setUpAshley() {
        engine = new PooledEngine();
        GameWorld ashleyWorld = new GameWorld(engine);

        //Add systems to engine
        addSystems(engine);

        //Add entities
        addEntities(ashleyWorld);

    }

    public void addSystems(PooledEngine engine) {
        engine.addSystem(new UserSystem());
        engine.addSystem(new RenderSystem(batch));
        engine.addSystem(new MovementSystem());
    }

    public void addEntities(GameWorld world) {

        //Create Rat
        world.createRat();

    }

    public void update() {
        engine.update(Gdx.graphics.getDeltaTime());
    }

    public PooledEngine getEngine() {
        return engine;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setGame(RatAttack game) {
            this.game = game;
    }
}
