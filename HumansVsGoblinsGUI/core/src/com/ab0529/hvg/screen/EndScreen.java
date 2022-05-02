package com.ab0529.hvg.screen;

import com.ab0529.hvg.HVG;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class EndScreen extends AbstractScreen {
    private Viewport gameViewport;
    private SpriteBatch batch;
    private BitmapFont font;

    private String text;

    public EndScreen(HVG app, String text) {
        super(app);

        batch = new SpriteBatch();
        gameViewport = new ScreenViewport();
        font = new BitmapFont();

        this.text = text;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameViewport.apply();

        batch.begin();

        font.draw(batch, text, gameViewport.getScreenWidth() / 2, gameViewport.getScreenHeight() / 2);

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
