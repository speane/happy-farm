package com.speane.happyfarm.table;

public class UiProgressBarInner extends Widget {

    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_HEIGHT = 20;
    private static final String DEFAULT_TEXTURE_NAME = "progress_bar";

    private ValueObserver<Float> valueObserver;

    public void setValueObserver(ValueObserver valueObserver) {
        this.valueObserver = valueObserver;
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
        return valueObserver != null && valueObserver.getValue() > 0
                ? valueObserver.getValue() < 1
                        ? valueObserver.getValue()
                        : 1
                : 0;
    }
}
