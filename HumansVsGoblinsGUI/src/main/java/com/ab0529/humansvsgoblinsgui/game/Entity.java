package com.ab0529.humansvsgoblinsgui.game;

import java.util.ArrayList;

/**
 * Entity class
 * All entities have health, strength, and inventory
 */
public abstract class Entity {
    private int health;
    private int strength;
    private String icon;
    private int x;
    private int y;

    private Inventory inventory;

    public Entity(int health, int strength) {
        this.health = health;
        this.strength = strength;
        inventory = new Inventory();
    }



    // Getters and setters


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
