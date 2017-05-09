package com.speane.happyfarm.table;

public class UiCellMenu extends Widget {

    private static final float DEFAULT_WIDTH = 300;
    private static final float DEFAULT_HEIGHT = 100;
    private static final String DEFAULT_TEXTURE_NAME = "cell_menu";

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
