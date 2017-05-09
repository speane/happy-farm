package com.speane.happyfarm.table;

public class UiButton extends Widget {

    private static final float DEFAULT_WIDTH = 100;
    private static final float DEFAULT_HEIGHT = 20;
    private static final String DEFAULT_TEXTURE_NAME = "button";

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
}
