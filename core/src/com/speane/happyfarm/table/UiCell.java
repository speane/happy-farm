package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UiCell extends Widget {

    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_OFFSET = 5;

    private UiEntityContainer entityContainer;

    public UiCell() {
        setTexture(new TextureRegion(new Texture("cell.png")));
        initEntityContainer();
    }

    @Override
    public float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return DEFAULT_WIDTH;
    }

    private void initEntityContainer() {
        entityContainer = new UiEntityContainer();
        entityContainer.setSize(getWidth(), getHeight());
        appendChild(entityContainer, 0, 0);
        System.out.println(getX() + " " + getY() + " " + entityContainer.getX() + " " + entityContainer.getY());
    }

    private float getInnerAreaWidth() {
        return getWidth() - getHorizontalOffset() * 2;
    }

    private float getInnerAreaHeight() {
        return getHeight() - getVerticalOffset() * 2;
    }

    private float getHorizontalOffset() {
        return getHeight() * getOffsetRatio();
    }

    private float getVerticalOffset() {
        return getWidth() * getOffsetRatio();
    }

    private float getOffsetRatio() {
        return DEFAULT_OFFSET / DEFAULT_WIDTH;
    }
}
