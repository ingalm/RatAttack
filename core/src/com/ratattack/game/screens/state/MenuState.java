package com.ratattack.game.screens.state;

import com.badlogic.gdx.Screen;
import com.ratattack.game.screens.ScreenFactory;

import java.time.Clock;

public class MenuState implements IScreenState {

    /***
     * TODO: LEGG TIL KOMMENTARER
     * */

    private StateManager stateManager;
    private Screen currentScreen;

    public MenuState(StateManager stateManager) {
        this.stateManager = stateManager;
        currentScreen = ScreenFactory.getScreen("MENU");

        renderScreen();

    }

    @Override
    public void changeState(IScreenState state) {
        stateManager.changeState(state);
        System.out.println("the state is menu and is now changing");
    }


    @Override
    public boolean shouldChangeState(String type) {

        return type.equalsIgnoreCase("GAME") ||  type.equalsIgnoreCase("TUTORIAL");
    }

    @Override
    public void changeScreen(String type) {
        if(shouldChangeState(type)){
            IScreenState state = type.equalsIgnoreCase("GAME") ? new GameState(stateManager): new TutorialState(stateManager);
            changeState(state);
        } else {
            currentScreen = ScreenFactory.getScreen(type);
            renderScreen();
        }
        System.out.println("the screen is now changing to " + type);

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
