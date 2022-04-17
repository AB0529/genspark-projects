import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {

    @Test
    void attack() {
        Goblin g = new Goblin(3, 10);
        Human h = new Human(10);

        g.attack(h);

        assertEquals(7, h.getHealth(), "Goblin did not attack for correct dmg");
    }
}