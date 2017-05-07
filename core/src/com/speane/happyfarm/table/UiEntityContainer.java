package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UiEntityContainer extends UiWrapper {
    
    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_OFFSET = 5;

    private UiEntity entity;

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
        setTexture(new TextureRegion(new Texture("container.png")));
        entity = new UiEntity();
        entity.setSize(getInnerAreaWidth(), getInnerAreaHeight());
        appendChild(entity, getHorizontalOffset(), getVerticalOffset());
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
