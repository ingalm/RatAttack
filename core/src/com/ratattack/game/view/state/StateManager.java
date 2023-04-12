package com.ratattack.game.view.state;

import com.ratattack.game.gamecontroller.GameController;

import java.util.Stack;

public class StateManager {


    /***
     * TODO: LEGG TIL KOMMENTARER
     * */

    public Stack<IState> states;
    public GameController gameController = GameController.getInstance();

    /***
     * This class manages all of the states and keeps track of current state in the stack.
     * state top of the stack gets rendered.
     */
    public StateManager() {
        states  = new Stack<>();
    }

    public void push(IState state){
        states.push(state);
    }

    private void pop(){
        states.pop();
    }

    void changeState(IState state){
        pop();
        states.push(state);
    }

    public void changeScreen(String type){
        states.peek().changeScreen(type);
    }

}
