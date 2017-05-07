package com.speane.happyfarm.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.speane.happyfarm.render.Renderer;
import com.speane.happyfarm.table.UiView;

public class MainScreen extends ScreenAdapter {

    private Renderer renderer;

    public MainScreen() {
        renderer = new Renderer(new SpriteBatch());
        renderer.addRenderable(new UiView());
    }

    @Override
    public void render(float delta) {
        renderer.render();
    }
}
