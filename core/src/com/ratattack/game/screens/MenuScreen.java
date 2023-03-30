package com.ratattack.game.screens;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;
import com.ratattack.game.gamecontroller.GameController;
import com.ratattack.game.model.GameWorld;
import com.ratattack.game.model.entity.system.BulletSystem;
import com.ratattack.game.model.entity.system.GrandchildSystem;
import com.ratattack.game.model.entity.system.GrandmotherSystem;
import com.ratattack.game.model.entity.system.RatSystem;
import com.ratattack.game.model.entity.system.UserSystem;

import java.io.IOException;

public class MenuScreen implements Screen {

    GameController gameController;

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

    public MenuScreen(GameController gameController) {
        this.gameController = gameController;
        setUpAshley();
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

    public void addEntities(GameWorld world) throws IOException {
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

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
