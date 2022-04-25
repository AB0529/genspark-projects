import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        Hangman hangman = new Hangman("Among Us");
        boolean win = hangman.getCurrentState().equalsIgnoreCase(hangman.getWord());
        Scanner s = new Scanner(System.in);
        FileUtils fileUtils = new FileUtils("src/java/resources/scores.properties");

        while (true) {
            hangman.getUsername();
            hangman.clearScreen();
            System.out.println(hangman);
            System.out.println(hangman.getCurrentState());
            System.out.println("Wrong Guesses: " + hangman.getWrongsSet().toString());

            if (hangman.wrongsSet.size() >= 6) {
                System.out.println("Uh oh, looks like you lost!");

                if (!exitPrompt(hangman, fileUtils, s))
                    break;

                play();
            }

            if (win) {
                System.out.println("Good job, you won!");

                if (!exitPrompt(hangman, fileUtils, s))
                    break;

                play();
            }

            System.out.println("Guess a letter: ");
            hangman.guessLetter(s.nextLine().toUpperCase().charAt(0));
            win = hangman.getCurrentState().equalsIgnoreCase(hangman.getWord());
        }
    }

    public static boolean exitPrompt(Hangman hangman, FileUtils fileUtils, Scanner s) {
        System.out.println("Score: " + hangman.getUserScore());
        fileUtils.write(hangman.getUsername(), String.valueOf(hangman.getUserScore()));

        fileUtils.read();
        System.out.println("#--- Leaderboard ---#");
        fileUtils.getProps().entrySet().forEach(System.out::println);

        System.out.println("Would you like to play again? (y or n)");
        String str = s.nextLine();

        return str.equalsIgnoreCase("y");
    }
}
