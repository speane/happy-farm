package com.speane.happyfarm.screen.start;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.speane.happyfarm.render.Renderer;
import com.speane.happyfarm.screen.AbstractView;
import com.speane.happyfarm.table.UiImage;
import com.speane.happyfarm.table.Widget;

public class StartScreenView extends Widget implements AbstractView {

    private static final float DEFAULT_WIDTH = 640;
    private static final float DEFAULT_HEIGHT = 640;

    private UiImage mainTitleImage = new UiImage();
    private static final float MAIN_TITLE_IMAGE_WIDTH = DEFAULT_WIDTH / 5 * 4;
    private static final float MAIN_TITLE_IMAGE_HEIGHT = DEFAULT_HEIGHT / 3;
    private static final float MAIN_TITLE_IMAGE_X = (DEFAULT_WIDTH - MAIN_TITLE_IMAGE_WIDTH) / 2;
    private static final float MAIN_TITLE_IMAGE_Y = (DEFAULT_HEIGHT - MAIN_TITLE_IMAGE_HEIGHT) / 3 * 2;
    private static final String MAIN_TITLE_IMAGE_TEXTURE_NAME = "main_title";

    private Renderer renderer;

    public void render() {
        renderer.render();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    protected void init() {
        initRenderer();
        initUi();
    }

    @Override
    protected float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    protected float getDefaultHeight() {
        return DEFAULT_HEIGHT;
    }

    @Override
    protected String getDefaultTextureName() {
        return null;
    }

    private void initUi() {
        setVisible(true);
        initMainTitleImage();
    }

    private void initRenderer() {
        renderer = new Renderer(new SpriteBatch());
        renderer.addRenderable(this);
    }

    private void initMainTitleImage() {
        mainTitleImage = new UiImage();
        mainTitleImage.setSize(MAIN_TITLE_IMAGE_WIDTH, MAIN_TITLE_IMAGE_HEIGHT);
        mainTitleImage.setTexture(MAIN_TITLE_IMAGE_TEXTURE_NAME);
        mainTitleImage.setVisible(true);
        appendChild(mainTitleImage, MAIN_TITLE_IMAGE_X, MAIN_TITLE_IMAGE_Y);
    }
}
