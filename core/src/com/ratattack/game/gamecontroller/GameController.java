package com.ratattack.game.gamecontroller;

import com.google.firebase.firestore.FirebaseFirestore;

public class GameController {

    //Model
    //new Ashley ECS
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public GameController() {

    }

    public void update() {
        //Kall på updaten til alle forskjellige greier
    }
}
