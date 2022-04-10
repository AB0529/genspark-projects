import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonsCaveTest {
    DragonsCave dragonsCave;

    @BeforeEach
    void setUp() {
        dragonsCave = new DragonsCave();
        dragonsCave.setChoice(1);
    }

    @Test
    void getChoice() {
        assertEquals(1, dragonsCave.getChoice());
    }

    @AfterEach
    void tearDown() {
    }
}