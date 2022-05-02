package model;

public class MoveCode {
    MOVEMENT movement;
    Actor actor;

    public MoveCode(MOVEMENT movement, Actor actor) {
        this.movement = movement;
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public MOVEMENT getMovement() {
        return movement;
    }
}
