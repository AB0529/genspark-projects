import java.util.Random;

public class GuessTheNumber {
    private static Random rnd;
    public static int numberToGuess;

    GuessTheNumber() {
        rnd = new Random();
    }

    public static void generateNewNumber() {
        setNumberToGuess(rnd.nextInt(20) + 1);
    }

    public static int getNumberToGuess() {
        return numberToGuess;
    }

    public static void setNumberToGuess(int v) {
        numberToGuess = v;
    }

}
