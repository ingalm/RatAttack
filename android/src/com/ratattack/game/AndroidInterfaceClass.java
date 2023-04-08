package com.ratattack.game;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Her skal logikk for Firebase være!!
public class AndroidInterfaceClass implements FirebaseInterface {
    FirebaseDatabase database;
    DatabaseReference myRef;

    public AndroidInterfaceClass() {

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("melding");
    }

    @Override
    public void someFunction() {
        System.out.println("Just some function");
    }

    @Override
    public void firebaseTest() {
        if (myRef != null) {
            myRef.setValue("Hello, World!");
        }
        else {
            System.out.println("DatabaseReference was not set -> could not write to DB");
        }
    }
}