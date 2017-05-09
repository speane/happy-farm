package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Container;
import com.speane.happyfarm.entity.Entity;

public class UiEntityContainer extends UiWrapper {
    
    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_OFFSET = 5;
    private static final String DEFAULT_TEXTURE_NAME = "container";

    private UiEntity uiEntity;

    private Container container;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;

        removeEntity();
        if (container != null && container.getEntity() != null) {
            createEntity(container.getEntity());
        }
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

    private void removeEntity() {
        if (uiEntity != null) {
            removeChild(uiEntity);
        }
    }

    private void createEntity(Entity entity) {
        uiEntity = new UiEntity();
        uiEntity.setSize(getInnerAreaWidth(), getInnerAreaHeight());
        uiEntity.setVisible(true);
        uiEntity.setEntity(entity);
        appendChild(uiEntity, getHorizontalOffset(), getVerticalOffset());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UiEntityContainer that = (UiEntityContainer) o;

        if (uiEntity != null ? !uiEntity.equals(that.uiEntity) : that.uiEntity != null) return false;
        return container != null ? container.equals(that.container) : that.container == null;
    }

    @Override
    public int hashCode() {
        int result = uiEntity != null ? uiEntity.hashCode() : 0;
        result = 31 * result + (container != null ? container.hashCode() : 0);
        return result;
    }
}
