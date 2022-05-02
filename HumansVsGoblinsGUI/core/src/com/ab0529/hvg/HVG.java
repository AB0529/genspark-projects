package com.ab0529.hvg;

import com.ab0529.hvg.screen.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * HVG main class for the game
 */
public class HVG extends Game {
	// GameScreen the screen which is being showed
	private GameScreen screen;

	@Override
	public void create() {
		screen = new GameScreen(this);

		setScreen(screen);
	}

	@Override
	public void render() {
		// Clears the color buffer in between frames
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		super.render();
	}
}
