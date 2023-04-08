package com.ratattack.game.gamecontroller;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.ratattack.game.RatAttack;
import com.ratattack.game.model.GameWorld;
import com.ratattack.game.model.entity.system.BulletSystem;
import com.ratattack.game.model.entity.system.GrandchildSystem;
import com.ratattack.game.model.entity.system.GrandmotherSystem;
import com.ratattack.game.model.entity.system.RatSystem;
import com.ratattack.game.model.entity.system.UserSystem;
import com.ratattack.game.screens.GameScreen;
import com.ratattack.game.screens.MenuScreen;
import com.ratattack.game.screens.OptionScreen;
import com.ratattack.game.screens.ScreenFactory;
import com.ratattack.game.screens.TutorialScreen;

public class GameController {

    // Ashley
    private UserSystem userSystem;
    private RatSystem ratSystem;
    private GrandmotherSystem grandmotherSystem;
    private GrandchildSystem grandchildSystem;
    private BulletSystem bulletSystem;
    private Entity user;
    private Entity rat;
    private Entity grandmother;
    private Entity grandchild;
    private Entity bullet;

    RatAttack game; // Gjør denne til singleton
    public static PooledEngine engine = new PooledEngine();

    public GameController(RatAttack game) {
        this.game = game;
        setUpAshley();
    }

    public void setStartScreen() {
        setMenuScreen();
    }

    private void setGameScreen() {
        GameScreen gameScreen = new GameScreen(this, engine);
        game.setScreen(gameScreen);
    }

    private void setMenuScreen() {
        MenuScreen menuScreen = new MenuScreen(this);
        game.setScreen(menuScreen);
    }

    private void setOptionsScreen() {
        OptionScreen optionScreen = new OptionScreen(this);
        game.setScreen(optionScreen);
    }

    private void setTutorialScreen() {
        TutorialScreen tutorialScreen = new TutorialScreen(this);
        game.setScreen(tutorialScreen);
    }

    private void setUpAshley() {

        //BRUKE SYSTEMMANAGER FRA ASHLEY?
        PooledEngine engine = new PooledEngine();
        GameWorld ashleyWorld = new GameWorld(engine);

        //Add systems to engine
        addSystems(engine);

        //Add entities
        addEntities(ashleyWorld);

        userSystem = engine.getSystem(UserSystem.class);
        ratSystem = engine.getSystem(RatSystem.class);
        grandmotherSystem = engine.getSystem(GrandmotherSystem.class);
        grandchildSystem = engine.getSystem(GrandchildSystem.class);
        bulletSystem = engine.getSystem(BulletSystem.class);
        ScreenFactory.setEngine(engine);

        //merk her at det ikke er mulig å skille på entitetene i engine
        //når det kommer til get(index) metoden

        //test for å sjekke at man kan sette og hente brukernavn for user
        userSystem.setUsername(user, "SATAN");
        System.out.println(userSystem.getUsername(engine.getEntities().get(0)));

        //test for å sjekke at man kan sette og hente posisjon til rat
        ratSystem.setPositionX(rat, 5);
        System.out.println(ratSystem.getPositionX(engine.getEntities().get(1)));

        //test for å sjekke at man kan sette og hente posisjon til grandmother
        grandmotherSystem.setPositionX(grandmother, 4);
        System.out.println(grandmotherSystem.getPositionX(engine.getEntities().get(2)));

        //test for å sjekke at man kan sette og hente posisjon til grandchild
        grandchildSystem.setPositionX(grandchild, 3);
        System.out.println(grandchildSystem.getPositionX(engine.getEntities().get(3)));

        //test for å sjekke at man kan sette og hente posisjon til bullet
        bulletSystem.setPositionX(bullet, 2);
        System.out.println(bulletSystem.getPositionX(engine.getEntities().get(4)));

    }

    public void addSystems(PooledEngine engine) {
        engine.addSystem(new UserSystem());
        engine.addSystem(new RatSystem());
        engine.addSystem(new GrandmotherSystem());
        engine.addSystem(new GrandchildSystem());
        engine.addSystem(new BulletSystem());
    }

    public void addEntities(GameWorld world) {
        //Create User
        user = world.createUser();

        //Create Rat
        rat = world.createRat();

        //Create grandmother
        grandmother = world.createGrandmother();

        //Create grandchild
        grandchild = world.createGrandchild();

        //Create bullet
        bullet = world.createBullet();
    }

    public void update() {
        //ratSystem.updateRats();
        //updateBullets();
        //updateGrandChildren();

        //Alt under her skal gjøres i screen
        //Slett alt innhold på skjermen
        //Tegn bakgrunn
        //Tegn knapper
        //Tegn highscore
        //Tegn balanse
        //Tegn alle rotter i rottesystemet
        //Tegn alle kuler i kulesystemet
        //Tegn alle barn i barnebarnsystemet
        //Tegn alle bestemødre i bestemødresystemet

    }
}
