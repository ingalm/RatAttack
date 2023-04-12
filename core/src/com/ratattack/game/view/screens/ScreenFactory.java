package com.ratattack.game.view.screens;

import com.badlogic.gdx.Screen;

public class ScreenFactory {

    public static Screen getScreen(String screenType) {
        switch (screenType) {
            case "MENU":
                return new MenuScreen();
            case "GAME":
                return new GameScreen();
            case "TUTORIAL":
                return new TutorialScreen();
            default:
                return null;
        }
    }
}
