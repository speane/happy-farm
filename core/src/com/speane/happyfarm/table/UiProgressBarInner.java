package com.speane.happyfarm.table;

public class UiProgressBarInner extends Widget {

    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_HEIGHT = 20;
    private static final String DEFAULT_TEXTURE_NAME = "progress_bar";

    private ProgressObserver progressObserver;

    public void setProgressObserver(ProgressObserver progressObserver) {
        this.progressObserver = progressObserver;
    }

    public float getCurrentWidth() {
        return getWidth() * getProgress();
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

    private float getProgress() {
        return progressObserver != null ? progressObserver.getProgress() : 0;
    }
}
