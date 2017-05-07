package com.speane.happyfarm.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.speane.happyfarm.HappyFarmGame;
import com.speane.happyfarm.render.Renderer;
import com.speane.happyfarm.table.UiMainScreenView;

public class MainScreen extends ScreenAdapter {

    private Renderer renderer;

    private HappyFarmGame game;

    public MainScreen(HappyFarmGame game) {
        renderer = new Renderer(new SpriteBatch());
        UiMainScreenView view = new UiMainScreenView();
        view.setContainers(game.getContainers());
        renderer.addRenderable(view);
    }

    @Override
    public void render(float delta) {
        renderer.render();
    }
}
