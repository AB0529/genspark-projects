package model;

public class Goblin extends Actor {
    private int health;
    private int strength;

    public Goblin(TileMap map, int x, int y, int health, int strength) {
        super(map, x, y);

        health = health;
        strength = strength;
    }


    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
