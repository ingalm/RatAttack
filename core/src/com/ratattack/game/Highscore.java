package com.ratattack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Highscore {
    private ArrayList<Score> highscores = new ArrayList<>();
    private BitmapFont font;
    FirebaseInterface _FBIC;


    public Highscore(FirebaseInterface _FBIC) {
        this._FBIC = _FBIC;
        font = new BitmapFont();
        font.getData().setScale(6f, 6f);
        fetchHighscores();
    }

    private int getNumberOfElements(ArrayList<Score> highscores) {
        int number;
        if (highscores.size()<10) {
            number = highscores.size();
        }
        else {
           number = 10;
        }
        return number;
    }

    public void render(SpriteBatch batch) {
        int xPosition = Gdx.graphics.getWidth() / 2 - 400;
        int yPosition = Gdx.graphics.getHeight() - 150;
        font.draw(batch, "HIGHSCORE LIST", xPosition, yPosition);
        for (int i = 0; i < getNumberOfElements(highscores)  ; i++) {
            int xPos = Gdx.graphics.getWidth() / 2 - 350;
            int yPos = Gdx.graphics.getHeight() - 300 - (i * 100);
            String text = (i + 1) + ". " + highscores.get(i).toString();
            font.draw(batch, text, xPos, yPos);
        }
    }

    private void fetchHighscores() {
        this.highscores.clear();
        _FBIC.getHighscores(this.highscores);
    }

    public void submitHighscore(String name, int score) {
        _FBIC.addHighscore(new Score(score, name));
    }

}
