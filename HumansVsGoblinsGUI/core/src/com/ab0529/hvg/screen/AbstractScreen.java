package com.ab0529.hvg.screen;

import com.ab0529.hvg.HVG;
import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen {

    private HVG app;

    public AbstractScreen(HVG app) {
        this.app = app;
    }

    @Override
    public abstract void show();

    @Override
    public abstract void render(float delta);

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public abstract void dispose();
}
