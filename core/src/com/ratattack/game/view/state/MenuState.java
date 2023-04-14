package com.ratattack.game.view.state;

import com.badlogic.gdx.Screen;
import com.ratattack.game.view.screens.ScreenFactory;

public class MenuState implements State {

    /***
     * TODO: LEGG TIL KOMMENTARER
     * */

    private ScreenContext stateManager;
    private Screen currentScreen;

    public MenuState(ScreenContext stateManager) {
        this.stateManager = stateManager;
        currentScreen = ScreenFactory.getScreen("MENU");

        renderScreen();

    }

    @Override
    public void changeState(State state) {
        stateManager.changeState(state);

    }


    @Override
    public boolean shouldChangeState(String type) {

        return type.equalsIgnoreCase("GAME") ||  type.equalsIgnoreCase("TUTORIAL");
    }

    @Override
    public void changeScreen(String type) {
        if(shouldChangeState(type)){
            State state = type.equalsIgnoreCase("GAME") ? new GameState(stateManager): new TutorialState(stateManager);
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
