import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hangman {
    public String username;
    public int userScore;

    public String currentState;
    public Set<Character> wrongsSet = new HashSet<>();
    public String body = "";

    private String word;
    public final FileUtils fileUtils = new FileUtils("src/java/resources/limbs.properties");

    public Hangman(String word) {
        this.word = word.toUpperCase();
        init();
    }

    public Hangman() {
        word = "CAT";
        init();
    }

    /**
     * Initializes the hangman game by asking for user's name
     * Sets a secret word
     * TODO: secret words from list
     */
    private void init() {
        currentState = word.chars()
                .map(c -> c = '_')
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

        StringBuilder sb = new StringBuilder(currentState);
        sb.setCharAt(word.indexOf(' '), ' ');
        currentState = sb.toString();
        fileUtils.read();
    }

    /**
     * Guesses a letter, if correct adds to the user score.
     * if wrong, adds a body part and removes 1 from the score
     * @param letter the letter guess
     * @return true if guess was correct, false otherwise
     */
    public boolean guessLetter(char letter) {
        // Guess is correct
        if (word.indexOf(letter) >= 0) {
            // Add letters to current state
            Stream<Integer> indexes = IntStream
                    .iterate(word.indexOf(letter), index -> index >= 0, index -> word.indexOf(letter, index + 1))
                    .boxed();

            StringBuilder sb = new StringBuilder(currentState);
            indexes.forEach(i -> sb.setCharAt(i, letter));
            sb.setCharAt(word.indexOf(' '), ' ');

            currentState = sb.toString();

            // Increment score
            ++userScore;

            return true;
        }
        // Guess is wrong
        wrongsSet.add(letter);
        body = getLimb();
        // Decrement score
        --userScore;

        return false;
    }

    @Override
    public String toString() {
        return "---\n" + body + "\n---\n";
    }

    // --- Utils ---

    /**
     * Determines the body type to return based on wrong guesses taken (0-6)
     * @return String representing the body
     */
    public String getLimb() {
        Properties p = fileUtils.getProps();
        String head = (String) p.get("head");
        String body = (String) p.get("body");
        String leftArm = (String) p.get("leftArm");
        String rightArm = (String) p.get("rightArm");
        String leftLeg = (String) p.get("leftLeg");
        String rightLeg = (String) p.get("rightArm");

        switch (wrongsSet.size()) {
            case 0:
                return "";
            case 1:
                return head;
            case 2:
                return head + "\n" + body;
            case 3:
                return head + "\n" + leftArm + body;
            case 4:
                return head + "\n" + leftArm + body + rightArm;
            case 5:
                return head + "\n" + leftArm + body + rightArm + "\n" + leftLeg;
            case 6:
                return head + "\n" + leftArm + body + rightArm + "\n" + leftLeg + rightLeg;
        }
        
        return "Uh oh, looks like you lost!";
    }


    /**
     * Clears the terminal screen using ASCII escape sequences
     */
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    /**
     * Prompts the user for a username and recursively checks if it's valid (can't be blank or empty)
     * @param username the username to verify
     * @return the verified username
     */
    public String verifyUsername(String username) {
        if (username.isEmpty() || username.isBlank()) {
            clearScreen();

            // Ask the user's name
            Scanner s = new Scanner(System.in);
            System.out.println("What is your name?");
            return verifyUsername(s.nextLine());
        }

        return username;
    }

    // --- Getters and setters ---

    public void setWrongsSet(Set<Character> wrongsSet) {
        this.wrongsSet = wrongsSet;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void setUsername(String username) {
        this.username = verifyUsername(username);
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public Set<Character> getWrongsSet() {
        return wrongsSet;
    }

    public String getCurrentState() {
        return currentState;
    }

    public String getWord() {
        return word;
    }

    public String getUsername() {
        if (username == null)
            setUsername("");

        return username;
    }

    public int getUserScore() {
        return userScore;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public FileUtils getFileUtils() {
        return fileUtils;
    }
}
