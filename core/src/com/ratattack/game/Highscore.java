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
        font.getData().setScale(2f);
        fetchHighscores();
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < highscores.size(); i++) {
            int xPos = Gdx.graphics.getWidth() / 2 - 30;
            int yPos = Gdx.graphics.getHeight() - 100 - (i * 50);
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
