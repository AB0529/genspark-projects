package model;

import com.badlogic.gdx.math.Interpolation;

/**
 * Player represents the player model
 */
public class Actor {
    private TileMap map;
    private int x;
    private int y;

    // Animation
    private float worldX, worldY; // Cords sprite gets rendered to
    private int srcX, srcY;
    private int destX, destY;
    private float animationTimer;
    private float ANIMATION_TIME = 0.5f;

    private ACTOR_STATE state;

    public Actor(TileMap map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;

        worldX = x;
        worldY = y;

        // Add actor to tile
        map.getTile(x, y).setActor(this);

        state = ACTOR_STATE.STANDING;
    }

    public enum ACTOR_STATE {
        WALKING,
        STANDING
    }

    public void update(float delta) {
        // Only update if state is walking
        if (state != ACTOR_STATE.WALKING)
            return;

        // Smoothing algorithm
        animationTimer += delta;
        worldX = Interpolation.linear.apply(srcX, destX, animationTimer/ANIMATION_TIME);
        worldY = Interpolation.linear.apply(srcY, destY, animationTimer/ANIMATION_TIME);

        // Animation has finished
        if (animationTimer > ANIMATION_TIME)
            finishMove();
    }

    /**
     * Move responsible for moving the actor
     * Will check for out of bounds and if a tile is occupied
     * @param dx how many units to move in the x axis
     * @param dy how many units to move in the y axis
     * @return boolean on if the move was successful or not
     */
    public boolean move(int dx, int dy) {
        // Check if actor is not in the middle of a move
        if (state != ACTOR_STATE.STANDING)
            return false;

        // Check is target position is in bounds
        if (x + dx >= map.getWidth() || x + dx < 0 || y + dy >= map.getHeight() || y + dy < 0)
            return false;

        // Check if tile we want to move to isn't occupied
        if (map.getTile(x + dx, y + dy).getActor() != null)
            return false;

        initalizeMove(x, y, dx, dy);

        // Remove actor from previous tile
        map.getTile(x, y).setActor(null);

        // Move actor
        x += dx;
        y += dy;

        // Set this actor on new tile
        map.getTile(x, y).setActor(this);

        return true;
    }

    private void initalizeMove(int oldX, int oldY, int dx, int dy) {
        srcX = oldX;
        srcY = oldY;

        destX = oldX + dx;
        destY = oldY + dy;

        worldY = oldY;
        worldX = oldX;

        animationTimer = 0f;
        state = ACTOR_STATE.WALKING;
    }

    private void finishMove() {
        state = ACTOR_STATE.STANDING;
        worldX = destX;
        worldY = destY;
        srcX = 0;
        srcY = 0;
        destX = 0;
        destY = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getWorldY() {
        return worldY;
    }

    public float getWorldX() {
        return worldX;
    }
}
