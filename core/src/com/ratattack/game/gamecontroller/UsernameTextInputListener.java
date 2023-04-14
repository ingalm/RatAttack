package com.ratattack.game.gamecontroller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.ratattack.game.model.Player;

public class UsernameTextInputListener implements Input.TextInputListener {

    @Override
    public void input(String userName) {
        GameController.getInstance().setPlayer(new Player(userName));
        GameController.getInstance().play();
    }

    @Override
    public void canceled() {

    }
}
