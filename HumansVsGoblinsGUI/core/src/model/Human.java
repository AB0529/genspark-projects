package model;

import com.ab0529.hvg.screen.EndScreen;

public class Human extends Actor {
    private String name;

    private int health;
    private int strength;

    private World world;

    public Human(TileMap map, int x, int y, int health, int strength) {
        super(map, x, y);

        name = "Human";

        this.health = health;
        this.strength = strength;
    }

    public Human(TileMap map, int x, int y, String name, int health, int strength) {
        super(map, x, y);

        this.name = name;

        this.health = health;
        this.strength = strength;
    }

    public void battle(MoveCode code) {
        // Lose
        if (health <= 0) {
            getGame().setScreen(new EndScreen(getGame(), "YOU LOSE!"));
            return;
        }
        // Win
        if (world.getActors().size() - 1 <= 0) {
            getGame().setScreen(new EndScreen(getGame(), "YOU WIN!"));
            return;
        }

        if (code.getMovement() != MOVEMENT.SPACE_OCCUPIED)
            return;


        world.removeActor(code.getActor());
        System.out.println("BATTLE");
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
