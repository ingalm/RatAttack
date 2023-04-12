package com.ratattack.game.screens;

import com.badlogic.gdx.Screen;
import com.ratattack.game.FirebaseInterface;
import com.ratattack.game.gamecontroller.GameController;

public class ScreenFactory {

    static FirebaseInterface _FBIC =  GameController.getInstance().getFirebaseInterface();

    public static Screen getScreen(String screenType) {
        switch (screenType) {
            case "MENU":
                return new MenuScreen();
            case "GAME":
                return new GameScreen();
            case "TUTORIAL":
                return new TutorialScreen();
            case "HIGHSCORE":
                return new HighscoreScreen(_FBIC);
            default:
                return null;
        }
    }
}
