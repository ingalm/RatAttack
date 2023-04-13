package com.ratattack.game.model.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ratattack.game.GameSettings;
import com.ratattack.game.gamecontroller.GameController;

public class UpgradeButton {

    Button button;
    int id;
    Stage stage = GameController.getInstance().getStage();

    Texture upgradeTexture = new Texture("purplebutton.png");

    public UpgradeButton(int laneWidth, final int i) {
        id = i;

        button = new Button(new TextureRegionDrawable(new TextureRegion(upgradeTexture)));
        button.setSize(200, 200);
        button.setPosition(laneWidth*i + (float)(laneWidth-upgradeTexture.getWidth())/2, GameSettings.grandmotherLine);


        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent inputEvent, float xpos, float ypos) {
                GameController.getInstance().field.grandmaButtons.get(i).upgrade();
            }
        });

        stage.addActor(button);
    }

    public Button getButton() {
        return button;
    }
}
