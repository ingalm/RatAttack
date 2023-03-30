package com.ratattack.game.model.entity.system;

import com.ratattack.game.model.entity.components.SpriteComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JPanel;
import javax.swing.text.html.parser.Entity;

public class RenderSystem {
    private ArrayList<Entity> entities;
    private JPanel panel;

    public RenderSystem(JPanel panel){
        this.entities = new ArrayList<Entity>();
        this.panel = panel;
    }

    public void update() {
        Graphics g = panel.getGraphics();
        Graphics2D g2d = (Graphics2D)g;

        // Clear the screen
        g2d.clearRect(0, 0, panel.getWidth(), panel.getHeight());

        // Render each entity
        for (Entity entity : entities) {
            // Get the sprite component
            SpriteComponent sprite = gameWorld.sprite;

            // Draw the sprite to the screen
            if (sprite != null) {
                BufferedImage image = sprite.getImage();
                g2d.drawImage(image, 100,
                        100, null);
            }
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
}
