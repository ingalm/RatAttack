package com.ratattack.game.screens;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.ratattack.game.RatAttack;
import com.ratattack.game.gamecontroller.GameController;

public class ScreenFactory {

    public static GameController controller = GameController.getInstance();
    public static PooledEngine engine = controller.getEngine();

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
}
