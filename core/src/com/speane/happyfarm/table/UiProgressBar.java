package com.speane.happyfarm.table;

public class UiProgressBar extends UiWrapper {

    private static final float DEFAULT_WIDTH = 200;
    private static final float DEFAULT_HEIGHT = 10;
    private static final float DEFAULT_HORIZONTAL_OFFSET = 2;
    private static final float DEFAULT_VERTICAL_OFFSET = 2;
    private static final String DEFAULT_TEXTURE_NAME = "progress_bar_outer";

    private UiProgressBarInner progressBarInner;

    public void setValueObserver(ValueObserver valueObserver) {
        progressBarInner.setValueObserver(valueObserver);
    }

    public void setProgressBarTexture(String texture) {
        progressBarInner.setTexture(texture);
    }

    @Override
    protected void init() {
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
        return DEFAULT_TEXTURE_NAME;
    }

    @Override
    protected float getDefaultHorizontalBorderOffset() {
        return DEFAULT_HORIZONTAL_OFFSET;
    }

    @Override
    protected float getDefaultVerticalBorderOffset() {
        return DEFAULT_VERTICAL_OFFSET;
    }

    private void initUi() {
        initProgressBarInner();
    }

    private void initProgressBarInner() {
        progressBarInner = new UiProgressBarInner();
        progressBarInner.setSize(getInnerAreaWidth(), getInnerAreaHeight());

        progressBarInner.setVisible(true);
        appendChild(progressBarInner, getHorizontalOffset(), getVerticalOffset());
    }
}
