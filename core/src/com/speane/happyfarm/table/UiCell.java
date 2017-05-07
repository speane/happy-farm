package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UiCell extends UiWrapper {

    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_OFFSET = 5;

    private UiEntityContainer entityContainer;

    @Override
    public float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return DEFAULT_WIDTH;
    }

    @Override
    protected void init() {
        setTexture(new TextureRegion(new Texture("cell.png")));
        entityContainer = new UiEntityContainer();
        entityContainer.setSize(getInnerAreaWidth(), getInnerAreaHeight());
        appendChild(entityContainer, getHorizontalOffset(), getVerticalOffset());
    }

    @Override
    protected float getDefaultHorizontalBorderOffset() {
        return DEFAULT_OFFSET;
    }

    @Override
    protected float getDefaultVerticalBorderOffset() {
        return DEFAULT_OFFSET;
    }
}
