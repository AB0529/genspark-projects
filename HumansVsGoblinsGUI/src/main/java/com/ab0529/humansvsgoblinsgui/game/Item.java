package com.ab0529.humansvsgoblinsgui.game;

/**
 * Item represents an item in the world and inventory
 * It contains and id, name, and the type it is
 */
abstract public class Item {
    private int id;
    private String name;
    private Object type;

    public Item() {}

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Object getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(Object type) {
        this.type = type;
    }
}
