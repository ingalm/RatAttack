package com.ratattack.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ratattack.game.gamecontroller.GameController;

import java.util.ArrayList;

public class Field {

    private final int laneNr = 4;

    SpriteBatch batch = GameController.getInstance().getBatch();

    Texture lane;
    Texture backgroundBox; // For bakgrunnen til highScore og balanse

    ArrayList<Integer> laneDividers = new ArrayList<>();

    int width = Gdx.graphics.getWidth();
    int height = Gdx.graphics.getHeight();

    public Field() {
        // Setter opp hvor lanesene er separert.
        // Brukes til å finne ut hvor de skal tegnes, og hvor enheter skal spawne/tegnes.
        for (int i = 0; i < laneNr; i++) {
            laneDividers.add((width/laneNr)*i);
        }

        lane = new Texture("lane.png");
        //backgroundBox = new Texture("backgroundBox.png");
    }

    public void draw() {
        batch.begin();
        for (Integer i : laneDividers) {
            batch.draw(lane, i, 0, width/laneNr, height);
        }
        batch.end();

    }
}
