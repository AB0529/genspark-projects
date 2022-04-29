package com.ab0529.humansvsgoblinsgui.game;

import java.util.HashMap;

public class Inventory {
    public HashMap<Integer, Item> inventory;

    public Inventory() {}

    /**
     * Adds an item to the entity's inventory
     * @param item the item to add
     * @return the item added
     */
    public Item addToInventory(Item item) {
        return inventory.put(item.getId(), item);
    }

    /**
     * Checks if entity has a weapon item
     * @return boolean if they have a weapon item
     */
    public boolean hasWeapon() {
        for (Item item : inventory.values())
            return item instanceof Weapon;

        return false;
    }

    /**
     * Gets the weapon item from an entity
     * @return the item
     */
    public Weapon getWeapon() {
        for (Item item : inventory.values())
            if (item instanceof Weapon)
                return (Weapon) item;

        return null;
    }

    /**
     * Checks if entity has a shield item
     * @return boolean if they have a shield item
     */
    public boolean hasShield() {
        for (Item item : inventory.values())
            return item instanceof Shield;

        return false;
    }

    /**
     * Gets the shield item from an entity
     * @return the item
     */
    public Shield getShield() {
        for (Item item : inventory.values())
            if (item instanceof Shield)
                return (Shield) item;

        return null;
    }

    // Getters and setters

    public HashMap<Integer, Item> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<Integer, Item> inventory) {
        this.inventory = inventory;
    }
}
