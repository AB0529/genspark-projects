import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Land land = new Land(5, 5);
        land.populateMap();

        while (true) {
            Land.clearScreen();
            System.out.println(land);
            System.out.println("Enter a direction (up, down, left, right): ");
            String direction = s.nextLine().toLowerCase();

            Object o;

            switch (direction) {
                case "up":
                    o = land.moveUp();
                    System.out.println(o);
                   if (o instanceof Goblin) {
                       land.startCombat((Goblin) o);
                   }
                    break;
                case "down":
                    o = land.moveDown();
                    if (o instanceof Goblin)
                        land.startCombat((Goblin) o);
                    break;
                case "left":
                    o = land.moveLeft();
                    if (o instanceof Goblin)
                        land.startCombat((Goblin) o);
                    break;
                case "right":
                    o = land.moveRight();
                    if (o instanceof Goblin)
                        land.startCombat((Goblin) o);
                    break;
                default:
            }
        }

    }
}
