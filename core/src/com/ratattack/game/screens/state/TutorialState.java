package com.ratattack.game.screens.state;

import com.badlogic.gdx.Screen;
import com.ratattack.game.screens.ScreenFactory;

public class TutorialState implements IScreenState {


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
    public void changeState(IScreenState state) {
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
            IScreenState state = type.equalsIgnoreCase("GAME") ? new GameState(stateManager): new MenuState(stateManager);
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

    @Override
    public void next(com.ratattack.game.screens.Screen screen) {

    }

    @Override
    public void prev(com.ratattack.game.screens.Screen screen) {

    }
}
