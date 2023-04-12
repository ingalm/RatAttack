package com.ratattack.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ratattack.game.GameSettings;
import com.ratattack.game.gamecontroller.GameController;
import com.ratattack.game.model.components.SpriteComponent;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Field {

    SpriteBatch batch = GameController.getInstance().getBatch();

    Texture lane;
    Texture backgroundBox; // For bakgrunnen til highScore og balanse

    ArrayList<Integer> laneDividers = new ArrayList<>();

    int width = Gdx.graphics.getWidth();
    int height = Gdx.graphics.getHeight();

    public Field() {
        // Setter opp hvor lanesene er separert.
        // Brukes til å finne ut hvor de skal tegnes, og hvor enheter skal spawne/tegnes.
        int laneWidth = width/GameSettings.laneNr;
        Texture texture = new Texture("grandmother.png");
        for (int i = 0; i < GameSettings.laneNr; i++) {
            laneDividers.add(laneWidth*i);
            GameController.getInstance().getAshleyWorld().createGrandmother(laneWidth*(i+1)-((laneWidth+texture.getWidth())/2), GameSettings.grandmotherLine);
        }

        lane = new Texture("lane.png");
        //backgroundBox = new Texture("backgroundBox.png");
    }

    public void draw() {
        batch.begin();
        for (Integer i : laneDividers) {
            batch.draw(lane, i, 0, (float) width/GameSettings.laneNr, height);
        }
        batch.end();

    }
}
