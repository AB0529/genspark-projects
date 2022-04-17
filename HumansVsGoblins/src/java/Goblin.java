import java.util.Random;

public class Goblin {
    private final String icon = "G";
    private final Random rand = new Random();

    int strength;
    int health;
    int x;
    int y;
    private int px;
    private int py;

    public Goblin() {}
    public Goblin(int strength, int health) {
        this.strength = strength;
        this.health = health;
    }

    public Human attack(Human h) {
        // Miss
        if (rand.nextInt(2) == 1)
            return h;

        // Attack
        h.setHealth(h.getHealth() - strength);
        return h;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPx() {
        return px;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getPy() {
        return py;
    }

    @Override
    public String toString() {
        return icon;
    }
}
