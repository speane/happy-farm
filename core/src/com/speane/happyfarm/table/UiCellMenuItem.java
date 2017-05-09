package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Cell;

public class UiCellMenuItem extends Widget {

    private static final float DEFAULT_WIDTH = 128;
    private static final float DEFAULT_HEIGHT = 128;

    private Cell cell;

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

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
        return null;
    }
}
