package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Container;

public class UiCell extends UiWrapper {

    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_OFFSET = 5;
    private static final String DEFAULT_TEXTURE_NAME = "cell";

    private UiEntityContainer entityContainer;

    public void setContainer(Container container) {
        entityContainer.setContainer(container);
    }

    @Override
    public float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return DEFAULT_WIDTH;
    }

    @Override
    protected String getDefaultTextureName() {
        return DEFAULT_TEXTURE_NAME;
    }

    @Override
    protected void init() {
        initUi();
    }

    @Override
    protected float getDefaultHorizontalBorderOffset() {
        return DEFAULT_OFFSET;
    }

    @Override
    protected float getDefaultVerticalBorderOffset() {
        return DEFAULT_OFFSET;
    }

    private void initUi() {
        initEntityContainer();
    }

    private void initEntityContainer() {
        entityContainer = new UiEntityContainer();
        entityContainer.setSize(getInnerAreaWidth(), getInnerAreaHeight());
        entityContainer.setVisible(true);
        entityContainer.setTouchable(false);
        appendChild(entityContainer, getHorizontalOffset(), getVerticalOffset());
    }
}
