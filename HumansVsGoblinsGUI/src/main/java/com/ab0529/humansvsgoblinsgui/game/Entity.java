package com.ab0529.humansvsgoblinsgui.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Entity class
 * All entities have health, strength, and inventory
 */
public abstract class Entity {
    private int health;
    private int strength;
    private int x;
    private int y;

    private Text icon;
    private Inventory inventory;

    public Entity(int health, int strength) {
        this.health = health;
        this.strength = strength;
        inventory = new Inventory();
    }

    // Movement
    public void moveUp() {
        setY(getY() - 1);
    }

    public void moveDown() {
        setY(getY() + 1);
    }

    public void moveLeft() {
        setX(getX() - 1);
    }

    public void moveRight() {
        setX(getX() + 1);
    }

    // Getters and setters

    public Text getIcon() {
        return icon;
    }

    public void setIcon(String path) {
        icon = new Text(path);
//        icon.setText(path);
//        icon = new ImageView();
//
//        icon.setFitWidth(82);
//        icon.setFitHeight(50);
//        icon.setImage( new Image(path) );
    }

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
