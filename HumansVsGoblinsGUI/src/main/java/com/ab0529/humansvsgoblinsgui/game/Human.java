package com.ab0529.humansvsgoblinsgui.game;

import java.util.ArrayList;


/**
 * Human class for the game
 * Represents the player as they are the only human
 */
public class Human extends Entity {
    private String name;

    public Human(String name) {
        super(20, 1);
        this.name = name;
    }

    public Human() {
        super(20, 1);
        name = "Human";
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
