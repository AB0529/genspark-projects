package com.ab0529.hvg.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import model.Actor;
import model.Human;
import model.MOVEMENT;
import model.MoveCode;

/**
 * PlayerController handles inputs relating to
 * Controlling the playyer
 */
public class PlayerController extends InputAdapter {
    private Human player;

    public PlayerController(Actor p) {
        player = (Human) p;
    }


    /**
     * Handles movement controls for the player
     * WSAD and Arrow Keys to move around
     * TODO: implement hold down to move
     * @param keycode one of the constants in {@link Input.Keys}
     * @return
     */
    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
            case Input.Keys.UP:
                player.battle(player.move(0, 1));
                break;
            case Input.Keys.S:
            case Input.Keys.DOWN:
                player.battle(player.move(0, -1));
                break;
            case Input.Keys.A:
            case Input.Keys.LEFT:
                player.battle(player.move(-1, 0));
                break;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
                player.battle(player.move(1, 0));
                break;
        }

        return false;
    }
}
