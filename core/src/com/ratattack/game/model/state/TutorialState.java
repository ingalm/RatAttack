package com.ratattack.game.model.state;

import com.badlogic.gdx.Screen;
import com.ratattack.game.screens.ScreenFactory;

public class TutorialState implements IState {


    /***
     * TODO: LEGG TIL KOMMENTARER
     * */


    private StateManager stateManager;
    private Screen currentScreen;

    public TutorialState(StateManager stateManager) {
        this.stateManager = stateManager;
        currentScreen = ScreenFactory.getScreen("TUTORIAL");

        renderScreen();

    }

    @Override
    public void changeState(IState state) {
        stateManager.changeState(state);

    }

    @Override
    public boolean shouldChangeState(String type) {
        return type.equalsIgnoreCase("GAME") ||
                type.equalsIgnoreCase("MENU") ;
    }

    @Override
    public void changeScreen(String type) {
        if(shouldChangeState(type)){
            IState state = type.equalsIgnoreCase("GAME") ? new GameState(stateManager): new MenuState(stateManager);
            changeState(state);
        }
        else {
            currentScreen = ScreenFactory.getScreen(type);
            renderScreen();
        }
    }

    @Override
    public void renderScreen() {

        stateManager.gameController.getGame().setScreen(currentScreen);
    }
}
