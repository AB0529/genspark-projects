package com.ab0529.hvg.screen;

import com.ab0529.hvg.HVG;
import com.ab0529.hvg.Settings;
import com.ab0529.hvg.controller.PlayerController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.Actor;
import model.Camera;
import model.TileMap;

import java.util.Set;

/**
 * GameScreen represents a "scene" of the game
 * TODO: Organize fields
 */
public class GameScreen extends AbstractScreen {
    private Camera camera;
    private PlayerController playerController;
    private Actor player;
    private TileMap map;
    private SpriteBatch batch;
    private Texture amogus;
    private Texture grass1;

    public GameScreen(HVG app) {
        super(app);

        amogus = new Texture(Gdx.files.internal("amogus.png"));
        grass1 = new Texture(Gdx.files.internal("grass1.png"));
        batch = new SpriteBatch();
        map = new TileMap(10, 10);
        player = new Actor(map, 0, 0);
        playerController = new PlayerController(player);
        camera = new Camera();
    }

    /**
     * Show runs when the screen is first showed
     */
    @Override
    public void show() {
        Gdx.input.setInputProcessor(playerController);
    }

    /**
     * Render draws to the screen
     * @param delta The time in seconds since the last render.
     * TODO: don't render not visible tiles
     */
    @Override
    public void render(float delta) {
        // Update player each frame
        player.update(delta);
        // Make sure the camera is focused in the center of the player
        camera.update(player.getWorldX() + 0.5f, player.getWorldY() + 0.5f);

        // Begin the sprite batch draw
        batch.begin();

        float worldStartX = (Gdx.graphics.getWidth() / 2) - (camera.getCameraX() * Settings.SCALED_TILE_SIZE);
        float worldStartY = (Gdx.graphics.getHeight( ) / 2) - (camera.getCameraY() * Settings.SCALED_TILE_SIZE);

        // Draw each tile of map
        for (int x = 0; x < map.getWidth(); x++)
            for (int y = 0; y < map.getHeight(); y++)
                batch.draw(
                        grass1,
                        worldStartX + x * Settings.SCALED_TILE_SIZE,
                        worldStartY + y * Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE);

        // Draw the player
        batch.draw(amogus,
                worldStartX + player.getWorldX() * Settings.SCALED_TILE_SIZE,
                worldStartY + player.getWorldY() * Settings.SCALED_TILE_SIZE,
                Settings.SCALED_TILE_SIZE,
                Settings.SCALED_TILE_SIZE * 1.5f);

        // End batch draw
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
