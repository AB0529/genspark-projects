package com.ab0529.humansvsgoblinsgui.controllers;

import com.ab0529.humansvsgoblinsgui.game.Human;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.HashSet;

public class GameController {
    private Human player;
//    private HashSet<En>

    @FXML
    GridPane grid;

    public GameController(Human player) {
        this.player = player;
        player.setIcon("H");
    }

    public void initialize() {
        Text t = new Text(player.getIcon());

        grid.add(t, 1, 1);
    }
}
