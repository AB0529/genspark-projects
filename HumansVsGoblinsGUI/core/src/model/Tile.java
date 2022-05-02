package model;

/**
 * Tile represents a tile in the tile map
 * Can contain an actor on it
 */
public class Tile {
    private TERRAIN terrain;
    private Actor actor;

    public Tile(TERRAIN terrain) {
        this.terrain = terrain;
    }

    public TERRAIN getTerrain() {
        return terrain;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
