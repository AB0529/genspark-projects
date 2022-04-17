import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {
    Land l;

    @BeforeEach
    void setUp() {
        l = new Land(3, 3);
        l.populateMap();
    }

    @Test
    void populateMap() {
        assertEquals(3, l.getBoard().length, "Board height is 3");
        assertEquals(3, l.getBoard()[0].length, "Board width is 3");
    }

    @Test
    void moveUp() {
        l.getPlayer().setX(0);
        l.getPlayer().setY(0);
        l.moveUp();
        assertEquals(0, l.getPlayer().getX(), "Move up can't move higher than board height");
        l.getPlayer().setX(1);
        l.getPlayer().setY(0);
        l.moveUp();
        assertEquals(0, l.getPlayer().getX(), "Player did not move up");
    }

    @Test
    void moveDown() {
        l.getPlayer().setX(1);
        l.getPlayer().setY(0);
        l.moveDown();
        assertEquals(2, l.getPlayer().getX(), "Move down can't go lower than 0");
        l.getPlayer().setX(1);
        l.getPlayer().setY(0);
        l.moveDown();
        assertEquals(2, l.getPlayer().getX(), "Player did not move down");
    }

    @Test
    void moveLeft() {
        l.getPlayer().setX(1);
        l.getPlayer().setY(0);
        l.moveLeft();
        assertEquals(0, l.getPlayer().getY(), "Move left can't go lower than 0");
        l.getPlayer().setX(1);
        l.getPlayer().setY(1);
        assertEquals(1, l.getPlayer().getX(), "Player did not move left");
    }

    @Test
    void moveRight() {
        l.getPlayer().setX(1);
        l.getPlayer().setY(0);
        l.moveRight();
        assertEquals(1, l.getPlayer().getY(), "Move left can't higher than board width");
        l.getPlayer().setX(1);
        l.getPlayer().setY(1);
        l.moveRight();
        assertEquals(1, l.getPlayer().getX(), "Player did not move right");
    }
}