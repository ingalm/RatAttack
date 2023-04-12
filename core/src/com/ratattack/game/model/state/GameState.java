package com.ratattack.game.model.state;

import com.badlogic.gdx.Screen;
import com.ratattack.game.screens.ScreenFactory;

public class GameState implements IState {


    /***
     * TODO: LEGG TIL KOMMENTARER
     * */
    private StateManager stateManager;
    private Screen currentScreen;

    public GameState(StateManager sm) {
        this.stateManager = sm;
        currentScreen = ScreenFactory.getScreen("GAME");

        renderScreen();
    }

    @Override
    public void changeState(IState state) {
        stateManager.changeState(state);
    }

    @Override
    public boolean shouldChangeState(String type) {

        return type.equalsIgnoreCase("MENU") ||  type.equalsIgnoreCase("TUTORIAL") ;
    }

    @Override
    public void changeScreen(String type) {

        if(shouldChangeState(type)){
            IState state = type.equalsIgnoreCase("MENU") ? new MenuState(stateManager): new TutorialState(stateManager);
            changeState(state);
        } else {
            currentScreen = ScreenFactory.getScreen(type);
            renderScreen();
        }

    }

    @Override
    public void renderScreen() {

        stateManager.gameController.getGame().setScreen(currentScreen);

    }
}
