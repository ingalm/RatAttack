package com.ratattack.game.gamecontroller;

import com.badlogic.ashley.core.PooledEngine;
import com.ratattack.game.RatAttack;
import com.ratattack.game.screens.GameScreen;
import com.ratattack.game.screens.MenuScreen;
import com.ratattack.game.screens.OptionScreen;
import com.ratattack.game.screens.TutorialScreen;

public class GameController {

    // Model
    // new Ashley ECS

    RatAttack game; // Gjør denne til singleton
    public static PooledEngine engine = new PooledEngine();

    public GameController(RatAttack game) {
        this.game = game;

    }

    public void setStartScreen() {
        setMenuScreen();
    }

    private void setGameScreen() {
        GameScreen gameScreen = new GameScreen(this, engine);
        game.setScreen(gameScreen);
    }

    private void setMenuScreen() {
        MenuScreen menuScreen = new MenuScreen(this);
        game.setScreen(menuScreen);
    }

    private void setOptionsScreen() {
        OptionScreen optionScreen = new OptionScreen(this);
        game.setScreen(optionScreen);
    }

    private void setTutorialScreen() {
        TutorialScreen tutorialScreen = new TutorialScreen(this);
        game.setScreen(tutorialScreen);
    }

    /*
     * setupEngine method which uses RenderSystem from entity - use PooledEngine
     * add all systems to engine.
     * add all functionality regarding pause, resume, quit etc.
     * some kind of gameWorldListener has to be used. Make GameWorld class?
     */

    public void update() {
        // Kall på updaten til alle forskjellige greier
    }
}
