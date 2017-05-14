package com.speane.happyfarm.ui;

public class UiImage extends Widget {

    private static final float DEFAULT_WIDTH = 320;
    private static final float DEFAULT_HEIGHT = 240;

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
}
