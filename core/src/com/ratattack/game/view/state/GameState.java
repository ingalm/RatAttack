package com.ratattack.game.view.state;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.ratattack.game.GameSettings;
import com.ratattack.game.gamecontroller.GameController;
import com.ratattack.game.model.system.SpawnSystem;
import com.ratattack.game.view.screens.ScreenFactory;

public class GameState implements State {


    /***
     * TODO: LEGG TIL KOMMENTARER
     * */
    private final ScreenContext stateManager;
    private Screen currentScreen;

    public GameState(ScreenContext sm) {
        this.stateManager = sm;
        currentScreen = ScreenFactory.getScreen("GAME");

        renderScreen();
    }

    @Override
    public void changeState(State state) {
        stateManager.changeState(state);
    }

    @Override
    public boolean shouldChangeState(String type) {

        return type.equalsIgnoreCase("MENU") ||  type.equalsIgnoreCase("TUTORIAL") ;
    }

    @Override
    public void changeScreen(String type) {

        if(shouldChangeState(type)){
            State state = type.equalsIgnoreCase("MENU") ? new MenuState(stateManager): new TutorialState(stateManager);
            changeState(state);
        } else {
            currentScreen = ScreenFactory.getScreen(type);
            renderScreen();
        }

    }

    @Override
    public void renderScreen() {
        GameController.getInstance().getEngine().getSystem(SpawnSystem.class).setProcessing(true);
        GameController.getInstance().getGame().setScreen(currentScreen);
    }
}
