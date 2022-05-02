package com.ab0529.hvg.screen;

import com.ab0529.hvg.HVG;
import com.ab0529.hvg.Settings;
import com.ab0529.hvg.controller.PlayerController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import model.*;

import java.util.Random;

/**
 * GameScreen represents a "scene" of the game
 */
public class GameScreen extends AbstractScreen {

    private World world;
    private Human player;
    private Camera camera;

    private Viewport gameViewport;
    private SpriteBatch batch;

    private PlayerController playerController;

    private Texture amogus;
    private Texture goblin;
    private Texture grass1;

    public GameScreen(HVG app) {
        super(app);

        world = new World(25, 25);
        batch = new SpriteBatch();
        gameViewport = new ScreenViewport();

        amogus = new Texture(Gdx.files.internal("amogus.png"));
        goblin = new Texture(Gdx.files.internal("goblin.png"));
        grass1 = new Texture(Gdx.files.internal("grass1.png"));

        player = new Human(world.getMap(), world.getMap().getWidth() / 2, world.getMap().getHeight() / 2, 10, 1);
        player.setTexture(amogus);

        player.setGame(app);

        world.addActor(player);

        Random random = new Random();
        random.setSeed(1);

        for (int i = 0; i < 1; i++) {
            int health = random.nextInt(20);
            int strength = random.nextInt(5);
            int x = random.nextInt(world.getMap().getWidth());
            int y = random.nextInt(world.getMap().getHeight());

            Goblin g = new Goblin(world.getMap(), x, y, health, strength);
            g.setTexture(goblin);

            world.addActor(g);
        }

        playerController = new PlayerController(player);

        camera = new Camera();

        player.setWorld(world);
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
        gameViewport.apply();

        // Update player each frame
        player.update(delta);
        // Make sure the camera is focused in the center of the player
        camera.update(player.getWorldX() + 0.5f, player.getWorldY() + 0.5f);

        // Begin the sprite batch draw
        batch.begin();

        float worldStartX = (Gdx.graphics.getWidth() / 2) - (camera.getCameraX() * Settings.SCALED_TILE_SIZE);
        float worldStartY = (Gdx.graphics.getHeight( ) / 2) - (camera.getCameraY() * Settings.SCALED_TILE_SIZE);

        // Draw each tile of map
        for (int x = 0; x < world.getMap().getWidth(); x++)
            for (int y = 0; y < world.getMap().getHeight(); y++)
                batch.draw(
                        grass1,
                        worldStartX + x * Settings.SCALED_TILE_SIZE,
                        worldStartY + y * Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE);

        // Draw each actor
        for (Actor a : world.getActors()) {
            batch.draw(a.getTexture(),
                    worldStartX + a.getWorldX() * Settings.SCALED_TILE_SIZE,
                    worldStartY + a.getWorldY() * Settings.SCALED_TILE_SIZE,
                    Settings.SCALED_TILE_SIZE,
                    Settings.SCALED_TILE_SIZE * 1.5f);
        }

        // End batch draw
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
        gameViewport.update(width, height);
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
