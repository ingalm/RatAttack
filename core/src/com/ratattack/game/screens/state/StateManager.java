package com.ratattack.game.screens.state;

import com.ratattack.game.gamecontroller.GameController;

import java.util.Stack;

public class StateManager {


    /***
     * TODO: LEGG TIL KOMMENTARER
     * */

    public Stack<IScreenState> states;
    public GameController gameController = GameController.getInstance();

    /***
     * This class manages all of the states and keeps track of current state in the stack.
     * state top of the stack gets rendered.
     */
    public StateManager() {
        states  = new Stack<>();
    }

    public void push(IScreenState state){
        states.push(state);
    }

    private void pop(){
        states.pop();
    }

    void changeState(IScreenState state){
        pop();
        states.push(state);
    }

    public void changeScreen(String type){
        states.peek().changeScreen(type);
    }

}
