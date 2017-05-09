package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Container;

public class UiEntityContainer extends UiWrapper {
    
    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_OFFSET = 5;
    private static final String DEFAULT_TEXTURE_NAME = "container";

    private UiEntity entity;

    private Container container;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
        entity.setVisible(container.getEntity() != null);
        entity.setEntity(container.getEntity() != null ? entity.getEntity() : null);
    }

    @Override
    protected void init() {
        initEntity();
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
    protected float getDefaultHorizontalBorderOffset() {
        return DEFAULT_OFFSET;
    }

    @Override
    protected float getDefaultVerticalBorderOffset() {
        return DEFAULT_OFFSET;
    }

    private void initEntity() {
        entity = new UiEntity();
        entity.setSize(getInnerAreaWidth(), getInnerAreaHeight());
        entity.setVisible(true);
        appendChild(entity, getHorizontalOffset(), getVerticalOffset());
    }
}
