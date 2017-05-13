package com.speane.happyfarm.table;

public class UiMenu extends Widget {

    private static final float WIDTH = 320;
    private static final float HEIGHT = 320;
    private static final String TEXTURE = "menu";

    private UiButton saveButton;
    private static final float SAVE_BUTTON_WIDTH = WIDTH / 5 * 4;
    private static final float SAVE_BUTTON_HEIGHT = HEIGHT / 5;
    private static final float SAVE_BUTTON_X = (WIDTH - SAVE_BUTTON_WIDTH) / 2;
    private static final float SAVE_BUTTON_Y = HEIGHT / 5 * 3;
    private static final String SAVE_BUTTON_TEXTURE = "menu_save_button";

    private UiButton exitButton;
    private static final float EXIT_BUTTON_WIDTH = SAVE_BUTTON_WIDTH;
    private static final float EXIT_BUTTON_HEIGHT = SAVE_BUTTON_HEIGHT;
    private static final float EXIT_BUTTON_X = SAVE_BUTTON_X;
    private static final float EXIT_BUTTON_Y = SAVE_BUTTON_Y - SAVE_BUTTON_HEIGHT * 2;
    private static final String EXIT_BUTTON_TEXTURE = "menu_exit_button";

    public void setSaveButtonHandler(TouchHandler<UiButton> touchHandler) {
        saveButton.setTouchHandler(touchHandler);
    }

    public void setExitButtonHandler(TouchHandler<UiButton> touchHandler) {
        exitButton.setTouchHandler(touchHandler);
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
        return TEXTURE;
    }

    @Override
    protected void init() {
        initUi();
    }

    private void initUi() {
        initSaveButton();
        initExitButton();
    }

    private void initSaveButton() {
        saveButton = new UiButton();
        saveButton.setVisible(true);
        saveButton.setTouchable(true);
        saveButton.setSize(SAVE_BUTTON_WIDTH, SAVE_BUTTON_HEIGHT);
        saveButton.setTexture(SAVE_BUTTON_TEXTURE);
        appendChild(saveButton, SAVE_BUTTON_X, SAVE_BUTTON_Y);
    }

    private void initExitButton() {
        exitButton = new UiButton();
        exitButton.setVisible(true);
        exitButton.setTouchable(true);
        exitButton.setSize(EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        exitButton.setTexture(EXIT_BUTTON_TEXTURE);
        appendChild(exitButton, EXIT_BUTTON_X, EXIT_BUTTON_Y);
    }
}
