import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        GuessTheNumber guessTheNumber = new GuessTheNumber();
        guessTheNumber.generateNewNumber();

        try {
            playGame(guessTheNumber.getNumberToGuess());
        } catch (InputMismatchException e) {
            throw e;
        }

        while (true) {
            // Play again prompt
            System.out.println("Would you like to play again? (y or n)");
            String playAgain = s.next().toLowerCase();

            if (playAgain.equals("y")) {
                try {
                    guessTheNumber.generateNewNumber();
                } catch (Exception e) {
                    throw e;
                }

                try {
                    playGame(guessTheNumber.getNumberToGuess());
                } catch (InputMismatchException e) {
                    throw e;
                }
            }
            else
                break;
        }

    }

    public static void playGame(int numberToGuess) {
        Scanner s = new Scanner(System.in);
        int guessesCount = 0;

        System.out.println("Hello! What is your name?");

        String name = s.nextLine();

        System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\n", name);

        int userGuess = -1;

        while (userGuess != numberToGuess) {
            System.out.println("Take a guess.");
            try {
                userGuess = s.nextInt();
            } catch (Exception e) {
                throw e;
            }

            // Too low
            if (userGuess < numberToGuess)
                System.out.println("Your guess is too low.");
            // Too high
            else if (userGuess > numberToGuess)
                System.out.println("Your guess is too high.");

            guessesCount++;
        }

        // Correct guess
        System.out.printf("Good job, %s! You guess my number in %d guesses!\n", name, guessesCount);
    }
}
