import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @org.junit.jupiter.api.Test
    void init() {
        Hangman hangman = new Hangman("Among Us");
        hangman.setUsername("Sus");

        assertEquals("Sus", hangman.getUsername(), "Username is not correct");
        assertEquals(8, hangman.getCurrentState().length(), "Current state size is not correct");
        assertEquals("_____ __", hangman.getCurrentState(), "Current state is not correct");
    }

    @org.junit.jupiter.api.Test
    void guessLetter() {
        Hangman hangman = new Hangman("Big Java");
        hangman.setUsername("Sus");

        // Correct guess
        assertTrue(hangman.guessLetter('a'), "Guess is wrong boolean");
        assertEquals("___ _a_a", hangman.getCurrentState(), "Current state is wrong");
        assertEquals(0, hangman.getWrongsSet().size(), "Wrong set size is not correct");
        assertEquals(1, hangman.getUserScore(), "Score is wrong");

        // Wrong guess
        assertFalse(hangman.guessLetter('z'), "Guess is wrong boolean");
        assertEquals(1, hangman.getWrongsSet().size(), "Wrong set size is not correct");
        assertEquals(0, hangman.getUserScore(), "Score is wrong");

        assertEquals("O", hangman.getBody(), "Body is wrong");
    }
}