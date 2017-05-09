package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Container;

public class UiGrid extends UiWrapper {

    private static final float DEFAULT_WIDTH = 384;
    private static final float DEFAULT_BORDER_OFFSET = 5;
    private static final String DEFAULT_TEXTURE_NAME = "table";

    private Container[][] containers;

    private UiCell[][] cells;

    private int rowCount;
    private int columnCount;

    public void setContainers(Container[][] containers) {
        if (containersAreCorrect(containers)) {
            this.containers = containers;
            rowCount = containers.length;
            columnCount = containers[0].length;
            initCells();
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
    protected void init() {
        initCells();
    }

    @Override
    protected float getDefaultHorizontalBorderOffset() {
        return DEFAULT_BORDER_OFFSET;
    }

    @Override
    protected float getDefaultVerticalBorderOffset() {
        return DEFAULT_BORDER_OFFSET;
    }

    private void initCells() {
        cells = new UiCell[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                UiCell cell = new UiCell();
                cell.setVisible(true);
                cell.setTouchable(true);
                cell.setSize(
                        getInnerAreaWidth() / columnCount,
                        getInnerAreaHeight() / rowCount);
                appendChild(
                        cell,
                        getHorizontalOffset() + getInnerAreaWidth() / columnCount * j,
                        getVerticalOffset() + getInnerAreaHeight() / rowCount * i);
                cell.setContainer(containers[i][j]);
                cells[i][j] = cell;
            }
        }
    }

    private boolean containersAreCorrect(Container[][] containers) {
        return containers != null && containers.length > 0 && containers[0] != null && containers[0].length > 0;
    }
}
