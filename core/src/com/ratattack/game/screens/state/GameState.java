package com.ratattack.game.screens.state;

import com.badlogic.gdx.Screen;
import com.ratattack.game.screens.ScreenFactory;

public class GameState implements IScreenState {


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
    public void changeState(IScreenState state) {
        stateManager.changeState(state);
    }

    @Override
    public boolean shouldChangeState(String type) {

        return type.equalsIgnoreCase("MENU") ||  type.equalsIgnoreCase("TUTORIAL") ;
    }

    @Override
    public void changeScreen(String type) {

        if(shouldChangeState(type)){
            IScreenState state = type.equalsIgnoreCase("MENU") ? new MenuState(stateManager): new TutorialState(stateManager);
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

    @Override
    public void next(com.ratattack.game.screens.Screen screen) {

    }

    @Override
    public void prev(com.ratattack.game.screens.Screen screen) {

    }
}
