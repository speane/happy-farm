package com.speane.happyfarm.screens.start;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.speane.happyfarm.render.Renderer;
import com.speane.happyfarm.screens.AbstractView;
import com.speane.happyfarm.ui.handler.TouchHandler;
import com.speane.happyfarm.ui.UiButton;
import com.speane.happyfarm.ui.UiImage;

public class UiStartScreenView extends AbstractView implements StartScreenView {

    private UiImage mainTitleImage;
    private static final float MAIN_TITLE_IMAGE_WIDTH = WIDTH / 5 * 4;
    private static final float MAIN_TITLE_IMAGE_HEIGHT = HEIGHT / 3;
    private static final float MAIN_TITLE_IMAGE_X = (WIDTH - MAIN_TITLE_IMAGE_WIDTH) / 2;
    private static final float MAIN_TITLE_IMAGE_Y = (HEIGHT - MAIN_TITLE_IMAGE_HEIGHT) / 5 * 4;
    private static final String MAIN_TITLE_IMAGE_TEXTURE_NAME = "start_screen_image";

    private UiButton startButton;
    private static final float START_BUTTON_WIDTH = WIDTH / 3;
    private static final float START_BUTTON_HEIGHT = HEIGHT / 15;
    private static final float START_BUTTON_X = (WIDTH - START_BUTTON_WIDTH) / 2;
    private static final float START_BUTTON_Y = (HEIGHT - START_BUTTON_HEIGHT) / 5 * 2;
    private static final String START_BUTTON_TEXTURE = "new_game_button";

    private UiButton loadButton;
    private static final float LOAD_BUTTON_WIDTH = START_BUTTON_WIDTH;
    private static final float LOAD_BUTTON_HEIGHT = START_BUTTON_HEIGHT;
    private static final float LOAD_BUTTON_X = START_BUTTON_X;
    private static final float LOAD_BUTTON_Y = START_BUTTON_Y - START_BUTTON_HEIGHT * 3 / 2;
    private static final String LOAD_BUTTON_TEXTURE = "load_button";

    private UiButton exitButton;
    private static final float EXIT_BUTTON_WIDTH = START_BUTTON_WIDTH;
    private static final float EXIT_BUTTON_HEIGHT = START_BUTTON_HEIGHT;
    private static final float EXIT_BUTTON_X = START_BUTTON_X;
    private static final float EXIT_BUTTON_Y = LOAD_BUTTON_Y - START_BUTTON_HEIGHT * 3 / 2;
    private static final String EXIT_BUTTON_TEXTURE = "start_screen_exit_button";

    private Renderer renderer;

    public void render() {
        renderer.render();
    }

    @Override
    public void setStartButtonTouchHandler(TouchHandler<UiButton> touchHandler) {
        startButton.setTouchHandler(touchHandler);
    }

    @Override
    public void setLoadButtonTouchHandler(TouchHandler<UiButton> touchHandler) {
        loadButton.setTouchHandler(touchHandler);
    }

    @Override
    public void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler) {
        exitButton.setTouchHandler(touchHandler);
    }

    @Override
    protected void init() {
        initRenderer();
        initUi();
    }

    @Override
    protected float getDefaultWidth() {
        return WIDTH;
    }

    @Override
    protected float getDefaultHeight() {
        return HEIGHT;
    }

    @Override
    protected String getDefaultTextureName() {
        return null;
    }

    private void initUi() {
        initMainTitleImage();
        initStartButton();
        initLoadButton();
        initExitButton();
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

    private void initStartButton() {
        startButton = new UiButton();
        startButton.setSize(START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
        startButton.setVisible(true);
        startButton.setTouchable(true);
        startButton.setTexture(START_BUTTON_TEXTURE);
        appendChild(startButton, START_BUTTON_X, START_BUTTON_Y);
    }

    private void initLoadButton() {
        loadButton = new UiButton();
        loadButton.setTouchable(true);
        loadButton.setVisible(true);
        loadButton.setSize(LOAD_BUTTON_WIDTH, LOAD_BUTTON_HEIGHT);
        loadButton.setTexture(LOAD_BUTTON_TEXTURE);
        appendChild(loadButton, LOAD_BUTTON_X, LOAD_BUTTON_Y);
    }

    private void initExitButton() {
        exitButton = new UiButton();
        exitButton.setTouchable(true);
        exitButton.setVisible(true);
        exitButton.setSize(EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        exitButton.setTexture(EXIT_BUTTON_TEXTURE);
        appendChild(exitButton, EXIT_BUTTON_X, EXIT_BUTTON_Y);
    }
}
