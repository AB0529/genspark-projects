import java.util.InputMismatchException;
import java.util.Scanner;

public class DragonsCave {
    private static Scanner s;
    public static int choice;

    DragonsCave() {
        s = new Scanner(System.in);
        choice = 0;
    }

    public static void getUserChoice() throws InputMismatchException {
        setChoice(s.nextInt());
    }

    public static int getChoice() {
        return choice;
    }

    public static void setChoice(int v) {
        choice = v;
    }
}
