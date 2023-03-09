package com.ratattack.game.screens;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;
import com.ratattack.game.RatAttack;
import com.ratattack.game.gamecontroller.GameController;

public class ScreenFactory {

    public static GameController controller;   //Singleton? for å hente samme objekt over alt
    public static PooledEngine engine = new PooledEngine();

    public static Screen getScreen(String screenType) {
        switch (screenType) {
            case "MENU":
                return new MenuScreen(controller);
            case "GAME":
                return new GameScreen(controller, engine);
            default:
                return null;
        }
    }

    public static void setEngine(PooledEngine engine) {
        ScreenFactory.engine = engine;
    }
}
