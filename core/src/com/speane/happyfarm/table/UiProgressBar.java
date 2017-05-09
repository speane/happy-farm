package com.speane.happyfarm.table;

public class UiProgressBar extends UiWrapper {

    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_HEIGHT = 30;
    private static final float DEFAULT_HORIZONTAL_OFFSET = 5;
    private static final float DEFAULT_VERTICAL_OFFSET = 5;
    private static final String DEFAULT_TEXTURE_NAME = "progress_bar_wrapper";

    private UiProgressBarInner progressBarInner;

    public void setProgressObserver(ProgressObserver progressObserver) {
        progressBarInner.setProgressObserver(progressObserver);
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
        System.out.println(getInnerAreaHeight());

        progressBarInner.setVisible(true);
        appendChild(progressBarInner, getHorizontalOffset(), getVerticalOffset());
    }
}
