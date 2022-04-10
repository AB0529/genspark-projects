import java.util.ArrayList;

public class Hangman {
    public static String missedLetters;
    public static String word;
    public static ArrayList<Character> correctLetters;
    public static boolean win;
    public static int failCount;

    Hangman() {
        missedLetters = "";
        word = "cat";
        correctLetters = new ArrayList<>();
        for (char ignored : word.toCharArray()) {
            correctLetters.add('_');
        }
        win = false;
        failCount = 6; // how many times you can guess wrong
    }

    public static void guess(char letter) {
        int pos = word.indexOf(letter);

        // Correct
        if (pos >= 0) {
            correctLetters.set(pos, letter);

            if (checkWin())
                win = true;

            return;
        }

        // Wrong
        missedLetters += letter;
    }

    public static boolean checkGuess(char l) {
        return missedLetters.indexOf(l) >= 0;
    }

    public static boolean checkWin() {
        StringBuilder correctLettersStr = new StringBuilder();
        for (char c : correctLetters)
            correctLettersStr.append(c);

        if ( correctLettersStr.toString().equals( word ) )
            return true;
        else if (missedLetters.length() >= failCount)
            return false;

        return false;
    }

    public String toString() {
        String body = "";

        if (missedLetters.isEmpty())
            body = "  |\n   |\n   |";

        switch (missedLetters.length()) {
            case 1: body = "O|\n  |\n  |"; break;
            case 2: body = "O |\n | |\n   |"; break;
            case 3: body = "O |\n/| |\n   |"; break;
            case 4: body = "O |\n/|\\|\n   |"; break;
            case 5: body = "O |\n/|\\|\n/| |"; break;
            case 6: body = "O |\n/|\\|\n/|\\|"; break;
        }

        return
                "+---+\n" +
                " " + body + "\n" +
                " ===\n" +
                "Missed letters: " + missedLetters + "\n" +
                "Word: " + correctLetters + "\n";
    }

    public static void setWord(String s) {
        word = s;
    }

    public static String getWord() {
        return word;
    }

    public static int getFailCount() {
        return failCount;
    }

    public static String getMissedLetters() {
        return missedLetters;
    }
}
