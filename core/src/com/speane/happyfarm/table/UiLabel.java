package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class UiLabel extends Widget {

    private BitmapFont font;

    private String text;

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected float getDefaultWidth() {
        return 0;
    }

    @Override
    protected float getDefaultHeight() {
        return 0;
    }

    @Override
    protected String getDefaultTextureName() {
        return null;
    }
}
