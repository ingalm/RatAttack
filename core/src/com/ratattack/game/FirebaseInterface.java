package com.ratattack.game;

import java.util.ArrayList;

// Her initialiserer vi bare hvilke functioner de andre klassene skal ha
// Med "de andre" mener jeg AndroidInterfaceClass, CoreInterfaceClass og DesktopInterfaceClass
public interface FirebaseInterface {


    public void getHighscores(ArrayList<Score> dataHolder);


    public void addHighscore(Score score, DataHolderClass dataholder);

}