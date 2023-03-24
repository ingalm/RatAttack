package com.ratattack.game.gamecontroller;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class GameController {

    //Model
    //new Ashley ECS
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public GameController() {
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");

        // Add a new document with a generated ID
        db.collection("users")
                .add(user);
    }

    public void update() {
        //Kall på updaten til alle forskjellige greier
    }
}
