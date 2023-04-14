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
    DatabaseReference myRef;

    DatabaseReference highscores;
    DataHolderClass dataholder;
    String myKey;

    public AndroidInterfaceClass() {

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("melding");
        highscores = database.getReference("highscores");
    }

    @Override
    public void someFunction() {
        System.out.println("Just some function");
    }

    @Override
    public void firebaseTest() {
        if (myRef != null) {
            myRef.setValue("HALLA balla!");
        }
        else {
            System.out.println("DatabaseReference was not set -> could not write to DB");
        }
    }

    @Override
    public void setOnValueChangedListener(final DataHolderClass dataholder) {
        // denne lytter på "melding" fordi myRef er satt i konstruktøren
        myRef.addValueEventListener(new ValueEventListener() {
            // les fra database
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // kalles én gang med initialverdi, og igjen hver gang data på
                // denne lokasjonen er oppdatert
                String value = snapshot.getValue(String.class);
                Log.d(TAG,"Value is " + value);
                //dataholder.someValue = value;
                System.out.println("FRA ONDATACHENGE!");
                //dataholder.PrintSomeValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value: ", error.toException());
            }
        });

    }

    @Override
    public void getHighscores(ArrayList<Score> dataHolder) {
        System.out.println("Getting highcores");
        highscores.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                //String key = "";
                System.out.println("Got highcores");
                Iterable<DataSnapshot> response = task.getResult().getChildren();
                for (DataSnapshot child : response) {
                    dataHolder.add(child.getValue(Score.class));
                    //sånn er det mulig å få tak i key:)
                    //key = child.getKey();
                }
                Collections.sort(dataHolder);
            }
        });
    }


    @Override
    public void setValueInDb(String target, String value) {
        // target blir opprettet hvis ikke eksisterer, i db
        myRef = database.getReference(target);
        myRef.setValue(value);
    }

    @Override
    public void addHighscore(Score score,  final DataHolderClass dataholder) {
        myKey = database.getReference("highscores").push().getKey();
        highscores.push().setValue(score);
        System.out.println("HER ER MYKEY: "+ myKey);
        dataholder.someValue = myKey;
    }



}
