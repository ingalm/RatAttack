package com.ratattack.game;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

import java.util.ArrayList;
import java.util.Collections;

// Her skal logikk for Firebase være!!
public class AndroidInterfaceClass implements FirebaseInterface {
    FirebaseDatabase database;

    DatabaseReference highscores;
    String myKey;

    public AndroidInterfaceClass() {

        database = FirebaseDatabase.getInstance();
        highscores = database.getReference("highscores");
    }

    @Override
    public void getHighscores(ArrayList<Score> scorelist) {
        System.out.println("Getting highcores");
        highscores.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                //String key = "";
                System.out.println("Got highcores");
                Iterable<DataSnapshot> response = task.getResult().getChildren();
                for (DataSnapshot child : response) {
                    scorelist.add(child.getValue(Score.class));
                    //sånn er det mulig å få tak i key:)
                    //key = child.getKey();
                }
                Collections.sort(scorelist);
            }
        });
    }

    @Override
    public void addHighscore(Score score,  final DataHolderClass dataHolder) {
        myKey = database.getReference("highscores").push().getKey();
        highscores.push().setValue(score);
        System.out.println("HER ER MYKEY: "+ myKey);
        dataHolder.someValue = myKey;
    }
}
