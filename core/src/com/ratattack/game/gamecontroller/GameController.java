package com.ratattack.game.gamecontroller;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ratattack.game.GameSettings;
import com.ratattack.game.RatAttack;
import com.ratattack.game.view.Field;
import com.ratattack.game.model.GameWorld;
import com.ratattack.game.model.system.BoundsSystem;
import com.ratattack.game.view.state.MenuState;
import com.ratattack.game.view.state.StateManager;
import com.ratattack.game.model.system.MovementSystem;
import com.ratattack.game.model.system.RenderSystem;
import com.ratattack.game.model.system.SpawnSystem;
import com.ratattack.game.model.system.UserSystem;
import com.ratattack.game.view.screens.OptionScreen;
import com.ratattack.game.view.screens.ScreenFactory;
import com.ratattack.game.view.screens.TutorialScreen;

public class GameController {

    private static final GameController instance = new GameController();

    public Field field;
    private Boolean paused = true;

    Stage stage;
    SpriteBatch batch;
    ShapeRenderer shapeRenderer;

    // Ashley
    private RatAttack game;

    private static GameWorld ashleyWorld;
    private static PooledEngine engine;

    public StateManager stateManager;

    private GameController() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
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

        //Add listeners
        engine.addEntityListener(new GameEntityListener(engine));

        //Add entities
        addEntities();
    }

    public void addSystems(PooledEngine engine) {
        engine.addSystem(new UserSystem());
        engine.addSystem(new MovementSystem());
        engine.addSystem(new SpawnSystem(engine, GameSettings.ratSpawnrate, GameSettings.grandChildSpawnrate));
        //engine.addSystem(new CollisionSystem());
        engine.addSystem(new BoundsSystem());
        engine.addSystem(new RenderSystem(batch, shapeRenderer));
    }

    public void addEntities() {
        //Create Rat
        //ashleyWorld.createRat();

    }

    public void update() {
        if (!paused) {
            engine.update(Gdx.graphics.getDeltaTime());
        }
        stage.draw();
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
    public Stage getStage() { return stage; }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public void setGame(RatAttack game) {
        this.game = game;
    }

}
