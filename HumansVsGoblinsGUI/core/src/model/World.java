package model;

import com.badlogic.gdx.math.GridPoint2;

import java.util.ArrayList;
import java.util.List;

public class World {

    private TileMap map;
    private List<Actor> actors;

    public World(int width, int height) {
        map = new TileMap(width, height);
        actors = new ArrayList<>();
    }

    /**
     * Adds an actor to the world
     * @param a the actor to add
     */
    public void addActor(Actor a) {
        map.getTile(a.getX(), a.getY()).setActor(a);
        actors.add(a);
    }


    /**
     * Removes an actor in the world
     * @param a the actor to remove
     */
    public void removeActor(Actor a) {
        map.getTile(a.getX(), a.getY()).setActor(null);
        actors.remove(a);
    }

    /**
     * Update runs the update method
     * @param delta the delta for each update method
     */
    public void update(float delta) {
        for (Actor a : actors)
            a.update(delta);
    }

    public TileMap getMap() {
        return map;
    }

    public List<Actor> getActors() {
        return actors;
    }
}
