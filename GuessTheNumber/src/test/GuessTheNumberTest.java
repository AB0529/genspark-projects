import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GuessTheNumberTest {
    GuessTheNumber guessTheNumber;

    @BeforeEach
    void setUp() {
        guessTheNumber = new GuessTheNumber();
    }

    @Test
    void getNumberToGuess() {
        // Generate new rnd number
        guessTheNumber.setNumberToGuess(50);
        assertEquals(50, guessTheNumber.getNumberToGuess());

    }

    @AfterEach
    void tearDown() {
    }
}