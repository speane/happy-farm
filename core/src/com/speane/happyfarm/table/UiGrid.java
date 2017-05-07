package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UiGrid extends Widget {

    private static final float DEFAULT_WIDTH = 384;
    private static final float DEFAULT_BORDER_OFFSET = 5;

    private UiCell[][] cells;

    public UiGrid(int rowCount, int columnCount) {
        setTexture(new TextureRegion(new Texture("table.png")));
        initCells(rowCount, columnCount);
    }

    @Override
    public float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return DEFAULT_WIDTH;
    }

    private void initCells(int rowCount, int columnCount) {
        cells = new UiCell[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                UiCell cell = new UiCell();
                cell.setSize(
                        getInnerAreaWidth() / columnCount,
                        getInnerAreaHeight() / rowCount);
                appendChild(
                        cell,
                        getHorizontalOffset() + getInnerAreaWidth() / columnCount * j,
                        getVerticalOffset() + getInnerAreaHeight() / rowCount * i);
                cells[i][j] = cell;
            }
        }
    }

    private float getInnerAreaWidth() {
        return getWidth() - getHorizontalOffset() * 2;
    }

    private float getInnerAreaHeight() {
        return getHeight() - getVerticalOffset() * 2;
    }

    private float getHorizontalOffset() {
        return getOffsetRatio() * getWidth();
    }

    private float getVerticalOffset() {
        return getOffsetRatio() * getHeight();
    }

    private float getOffsetRatio() {
        return DEFAULT_BORDER_OFFSET / DEFAULT_WIDTH;
    }
}
