package com.ratattack.game;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

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
            myRef.setValue("HALLA VERDEN!");
        }
        else {
            System.out.println("DatabaseReference was not set -> could not write to DB");
        }
    }

    @Override
    public void setOnValueChangedListener() {
        // denne lytter på "melding" fordi myRef er satt i konstruktøren
        myRef.addValueEventListener(new ValueEventListener() {
            // les fra database
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // kalles én gang med initialverdi, og igjen hver gang data på
                // denne lokasjonen er oppdatert
                String value = snapshot.getValue(String.class);
                Log.d(TAG,"Value is " + value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value: ", error.toException());
            }
        });
    }

    @Override
    public void setValueInDb(String target, String value) {
        // target blir opprettet hvis ikke eksisterer, i db
        myRef = database.getReference(target);
        myRef.setValue(value);
    }
}