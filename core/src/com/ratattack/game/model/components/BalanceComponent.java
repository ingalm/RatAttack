package com.ratattack.game.model.components;

import com.badlogic.ashley.core.Component;

public class BalanceComponent implements Component {

    int balance;

    public void setBalance(int x) {
        this.balance = x;
    }
}
