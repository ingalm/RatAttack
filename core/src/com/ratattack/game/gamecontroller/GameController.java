package com.ratattack.game.gamecontroller;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ratattack.game.DataHolderClass;
import com.ratattack.game.FirebaseInterface;
import com.ratattack.game.RatAttack;
import com.ratattack.game.model.Field;
import com.ratattack.game.model.GameWorld;
import com.ratattack.game.model.state.MenuState;
import com.ratattack.game.model.state.StateManager;
import com.ratattack.game.model.system.CollisionSystem;
import com.ratattack.game.model.system.MovementSystem;
import com.ratattack.game.model.system.RenderSystem;
import com.ratattack.game.model.system.SpawnSystem;
import com.ratattack.game.model.system.UserSystem;
import com.ratattack.game.screens.OptionScreen;
import com.ratattack.game.screens.ScreenFactory;
import com.ratattack.game.screens.TutorialScreen;

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

    FirebaseInterface _FBIC;
    DataHolderClass _dataHolder;

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

    public void setStartScreen() {

        stateManager = new StateManager();
        stateManager.push(new MenuState(stateManager));
    }

    private void setGameScreen() {
        try {
            game.setScreen(ScreenFactory.getScreen("GAME"));
        } catch (Exception e) {
            System.out.println("No game instance set for the game controller"); //Denne slår ut, og jeg skjønner ikke helt hvorfor. Men alt funker allikevel
        }
    }

    private void setMenuScreen() {
        try {
            game.setScreen(ScreenFactory.getScreen("MENU"));
        } catch (Exception e) {
            System.out.println("No game instance set for the game controller");
        }
    }

    private void setOptionsScreen() {
        OptionScreen optionScreen = new OptionScreen();
        game.setScreen(optionScreen);
    }

    private void setTutorialScreen() {
        TutorialScreen tutorialScreen = new TutorialScreen();
        game.setScreen(tutorialScreen);
    }

    private void setUpAshley() {
        engine = new PooledEngine();
        ashleyWorld = new GameWorld(engine);

        //Add systems to engine
        addSystems(engine);

        //Add entities
        addEntities();

    }

    public void addSystems(PooledEngine engine) {
        engine.addSystem(new UserSystem());
        engine.addSystem(new RenderSystem(batch));
        engine.addSystem(new MovementSystem());
        engine.addSystem(new SpawnSystem(engine, ratSpawnrate, grandChildSpawnrate));
        engine.addSystem(new CollisionSystem(engine));
    }

    public void addEntities() {
        //Create Rat
        //ashleyWorld.createRat();

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

    public FirebaseInterface getFirebaseInterface() {
        return _FBIC;
    }

    public void  setFirebaseInterface(FirebaseInterface FBIC) {
        this._FBIC = FBIC;
    }
    public void setDataHolderClass(DataHolderClass dataHolder) {
        this._dataHolder = dataHolder;
    }

    public DataHolderClass getDataHolderClass(){
        return _dataHolder;
    }
}
