public class Human {
    private final String icon = "H";
    private int health = 10;
    private int strength = 2;
    private int x;
    private int y;
    private int px;
    private int py;

    public Human() {}
    public Human(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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
