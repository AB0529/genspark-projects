import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class HangmanTest {
    Hangman hangman;

    @BeforeEach
    void setUp() {
        hangman = new Hangman();
    }

    @Test
    void getWord() {
        Hangman.setWord("amongus");
        assertEquals(Hangman.getWord(), "amongus");
    }

    @AfterEach
    void tearDown() {
    }
}