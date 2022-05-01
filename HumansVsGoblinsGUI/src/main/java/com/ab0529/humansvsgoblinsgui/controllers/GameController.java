package com.ab0529.humansvsgoblinsgui.controllers;

import com.ab0529.humansvsgoblinsgui.HVG;
import com.ab0529.humansvsgoblinsgui.game.Entity;
import com.ab0529.humansvsgoblinsgui.game.Goblin;
import com.ab0529.humansvsgoblinsgui.game.Human;
import com.ab0529.humansvsgoblinsgui.game.items.Pillow;
import com.ab0529.humansvsgoblinsgui.game.items.Stick;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameController {
    private Human player;
    private ArrayList<Entity> entities;
    private Random rand = new Random();

    @FXML
    GridPane grid;

    public GameController(Human player) {
        this.player = player;
        player.setIcon(player.getName());
        entities = new ArrayList<>();
        rand.setSeed(1);

        player.setX(0);
        player.setY(0);

        // Add player to 0, 0
        entities.add(player);

        // Generate some enemies
        int enemyCount = 10;

        for (int i = 0; i < enemyCount; i++) {
            int x = rand.nextInt(11);
            int y = rand.nextInt(11);

            Goblin g = new Goblin();

            // Assign random item to Goblin
            g.getInventory().addRandomItem();

            // Random health & strength
            g.setHealth(rand.nextInt(30));
            g.setStrength(rand.nextInt(10));

            g.setX(x);
            g.setY(y);
            g.setIcon("G" + x + "" + y);

            entities.add(g);
        }
    }

    // TODO: fix duplicates on draw
    public void drawEntities() {
        for (Entity e : entities) {
            int x = e.getX();
            int y = e.getY();

            grid.add(e.getIcon(), x, y);
        }
    }

    public void initialize() {
        // Add all entities to grid
        drawEntities();
    }

    @FXML
    protected void onKeyPress(KeyEvent e) {
        switch (e.getCode()) {
            case W:
                if (player.getY() - 1 < 0)
                    break;

                player.moveUp();
                drawEntities();
                break;
            case A:
                if (player.getX() - 1 < 0)
                    break;

                player.moveLeft();
                drawEntities();
                break;
            case S:
                if (player.getY() + 1 > 11)
                    break;

                player.moveDown();
                drawEntities();
                break;
            case D:
                if (player.getY() + 1 > 11)
                    break;

                player.moveRight();
                drawEntities();
                break;
        }
    }
}
