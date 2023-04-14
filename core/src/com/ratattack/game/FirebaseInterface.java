package com.ratattack.game;

import java.util.ArrayList;

// Her initialiserer vi bare hvilke functioner de andre klassene skal ha
// Med "de andre" mener jeg AndroidInterfaceClass, CoreInterfaceClass og DesktopInterfaceClass
public interface FirebaseInterface {

    public void someFunction();

    public void firebaseTest();

    public void setOnValueChangedListener(DataHolderClass dataholder);

    public void getHighscores(ArrayList<Score> dataHolder, DataHolderClass dataholder);

    public void setValueInDb(String target, String value);

    public void addHighscore(Score score, DataHolderClass dataholder);

}