import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Land {
    private int width;
    private int height;
    private Object[][] board;
    private final Random rand = new Random();
    private Human player;

    public Land() {}
    public Land(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new Object[width][height];
    }

    // populateMap populates the map with goblins and 1 human (player)
    public void populateMap() {
        int howManyGoblins = rand.nextInt(width*height) + 1;
        int w, h;

        for (int i = 0; i < howManyGoblins; i++) {
            w = rand.nextInt(width);
            h = rand.nextInt(height);

            Goblin goblin = new Goblin(rand.nextInt(10), rand.nextInt(10));
            goblin.setStrength(rand.nextInt(10));
            goblin.setX(w);
            goblin.setY(h);

            board[w][h] = goblin;
        }

        w = rand.nextInt(width);
        h = rand.nextInt(height);

        Object b = board[w][h];
        Human human = new Human(10);

        // Populate human
        while (!(b instanceof Human)) {
            if (!(board[w][h] instanceof Goblin)) {
                human.setX(w);
                human.setY(h);
                board[w][h] = human;
                break;
            }

            w = rand.nextInt(width);
            h = rand.nextInt(height);
            b = board[w][h];
        }

        player = human;
    }

    public void startCombat(Goblin g) {
        Scanner s = new Scanner(System.in);
        Human h = (Human) board[player.getX()][player.getY()];

        while (g.getHealth() > 0) {
            clearScreen();

            System.out.printf("GX: %d\nGY: %d\nHX: %d\nHY: %d\n", g.getX(), g.getY(), h.getX(), h.getY());

            System.out.println("--- BATTLE! ---");
            System.out.println("Human Health: " + h.getHealth());
            System.out.println("Goblin Health: " + g.getHealth());
            System.out.println("Goblin Strength: " + g.getStrength());

            // Human dies
            if (h.getHealth() <= 0) {
                System.out.println("You died.");
                System.exit(0);
            }

            // Goblin attacks first
            if (rand.nextInt(2) == 1) {
                System.out.println("The goblin attacks!");
                int oldHealth = h.getHealth();
                h = g.attack(h);

                if (oldHealth == h.getHealth())
                    System.out.println("MISS");
            }
            else {
                System.out.println("You attack!");
                g.setHealth(g.getHealth() - h.getStrength());
            }

            System.out.println("Press enter to continue...");
            s.nextLine();
        }

        board[h.getPx()][h.getPy()] = null;
        System.out.println("You have defeated the Goblin!");
    }

    // ----------
    // Movement
    // ----------

    public Object moveUp() {
        int x = player.getX();
        int y = player.getY();
        player.setPx(x);
        player.setPy(y);

        if (player.getX() - 1 < 0)
            return board[x][y];

        Object old = board[x][y];
        Object n = board[x - 1][y];

        board[x - 1][y] = old;
        board[x][y] = n;

        player.setX(x - 1);
        return n;
    }

    public Object moveDown() {
        int x = player.getX();
        int y = player.getY();
        player.setPx(x);
        player.setPy(y);

        if (x + 1 >= height)
            return board[x][y];

        Object old = board[x][y];
        Object n = board[x + 1][y];

        board[x + 1][y] = old;
        board[x][y] = n;

        player.setX(x + 1);
        return n;
    }

    public Object moveLeft() {
        int x = player.getX();
        int y = player.getY();
        player.setPx(x);
        player.setPy(y);

        if (y - 1 < 0)
            return board[x][y];

        Object old = board[x][y];
        Object n = board[x][y - 1];

        board[x][y - 1] = old;
        board[x][y] = n;

        player.setY(y - 1);
        return n;
    }

    public Object moveRight() {
        int x = player.getX();
        int y = player.getY();
        player.setPx(x);
        player.setPy(y);

        if (y + 1 >= width)
            return board[x][y];

        Object old = board[x][y];
        Object n = board[x][y + 1];

        board[x][y + 1] = old;
        board[x][y] = n;

        player.setY(y + 1);
        return n;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // -------------------
    // Getters and setters
    // -------------------
    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setBoard(Object[][] board) {
        this.board = board;
    }

    public Object[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        String b = "";

        for (Object[] i : board) {
            for (Object j : i)
                if (j == null)
                    b += " # ";
                else
                    b += " " + j + " ";

            b += "\n";
        }

        return b;
    }
}
