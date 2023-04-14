package com.ratattack.game;

import java.util.ArrayList;

public class CoreInterfaceClass implements FirebaseInterface {

    @Override
    public void someFunction() {
        System.out.println("wubbadubba");
    }

    @Override
    public void firebaseTest() {

    }
    @Override
    public void setOnValueChangedListener(DataHolderClass dataholder) {

    }

    @Override
    public void getHighscores(ArrayList<Score> dataHolder) {

    }

    @Override
    public void setValueInDb(String target, String value) {

    }

    @Override
    public void addHighscore(Score score, DataHolderClass dataholder) {

    }

}
