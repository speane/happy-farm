package com.speane.happyfarm.ui;

import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.entity.Container;

public class UiCell extends UiWrapper {

    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_OFFSET = 5;
    private static final String DEFAULT_TEXTURE_NAME = "cell";

    private UiEntityContainer entityContainer;

    private Cell cell;

    public void setCell(Cell cell) {
        this.cell = cell;
        if (cell != null && cell.getContainer() != null) {
            initEntityContainer(cell.getContainer());
        }
    }

    public Cell getCell() {
        return cell;
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

    private void initEntityContainer(Container container) {
        entityContainer = new UiEntityContainer();
        entityContainer.setSize(getInnerAreaWidth(), getInnerAreaHeight());
        entityContainer.setVisible(true);
        entityContainer.setTouchable(false);
        entityContainer.setContainer(container);
        appendChild(entityContainer, getHorizontalOffset(), getVerticalOffset());
    }
}
