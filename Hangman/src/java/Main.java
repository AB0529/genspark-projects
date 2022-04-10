import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ans;

        play();

        while (true) {
            System.out.println("Would you like to play again? (yes or no)");
            try {
                ans = s.nextLine();
            } catch (Exception e) {
                throw e;
            }

            if (ans.equals("yes"))
                play();
            else
                break;
        }
    }

    public static void play() {
        Scanner s = new Scanner(System.in);

        Hangman hangman = new Hangman();
        boolean win = Hangman.checkWin();

        System.out.println("H A N G M A N");
        System.out.println(hangman);

        while (!win) {
            char guess = guess(s, hangman);

            Hangman.guess(guess);
            System.out.println(hangman);

            if (Hangman.getMissedLetters().length() >= Hangman.getFailCount()) {
                break;
            }

            win = hangman.checkWin();
        }

        if (win)
            System.out.printf("Yes! The secret word is \"%s\"! You have won!\n", hangman.getWord());
    }

    public static char guess(Scanner s, Hangman hm) {
        System.out.println("Guess a letter.");
        char l;

        try {
            l = s.nextLine().charAt(0);
        } catch (Exception e) {
            throw e;
        }

        while (hm.checkGuess(l)) {
            System.out.println("You have already guessed that letter. Choose again.");
            System.out.println("Guess a letter");
            l = s.nextLine().charAt(0);
        }

        return l;
    }
}
