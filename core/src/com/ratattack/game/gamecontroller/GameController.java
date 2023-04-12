package com.ratattack.game.gamecontroller;

import java.util.HashMap;
import java.util.Map;

public class GameController {

    //Settings
    private final long ratSpawnrate = 2000;
    private final long grandChildSpawnrate = 2000;

    private static final GameController instance = new GameController();
    public Field field;
    private Boolean paused = true;

    SpriteBatch batch;

    // Ashley
    private RatAttack game;

    private static GameWorld ashleyWorld;
    private static PooledEngine engine;

    public StateManager stateManager;

    private GameController() {
        batch = new SpriteBatch();
        setUpAshley();
    }

    public RatAttack getGame(){
        return game;
    }

    public static GameController getInstance() {
        return instance;
    }

    public GameController() {
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");

        // Add a new document with a generated ID
    }

    public void update() {
        if (!paused) {
            engine.update(Gdx.graphics.getDeltaTime());
        }
    }

    public void setUpGame() {
        try {
            field = new Field();
        }
        catch (Exception e) {
            System.out.println("Error with field creation");
        }
    }

    public void play() {
        paused = false;
    }

    public void pause() {
        paused = true;
    }

    public PooledEngine getEngine() {
        return engine;
    }

    public GameWorld getAshleyWorld() {
        return ashleyWorld;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setGame(RatAttack game) {
        this.game = game;
    }

}
