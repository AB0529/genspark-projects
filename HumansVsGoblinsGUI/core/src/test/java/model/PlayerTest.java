package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void move() {
        Actor p = new Actor(new TileMap(16, 16), 1, 1);

        assertEquals(0, p.getX(), "Player x position is not correct");
        assertEquals(1, p.getY(), "Player y position is not correct");

        p.move(0, 1);
        assertEquals(2, p.getY(), "Player y position after move is not correct");
        p.move(1, 0);
        assertEquals(1, p.getX(), "Player x position after move is not correct");
    }
}