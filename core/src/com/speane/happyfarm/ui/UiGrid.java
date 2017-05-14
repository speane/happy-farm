package com.speane.happyfarm.ui;

import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.ui.handler.TouchHandler;

public class UiGrid extends UiWrapper {

    private static final float DEFAULT_WIDTH = 384;
    private static final float DEFAULT_BORDER_OFFSET = 5;
    private static final String DEFAULT_TEXTURE_NAME = "ui";

    private Cell[][] cells;

    private UiCell[][] uiCells;
    private TouchHandler<UiCell> cellTouchHandler;

    private int rowCount;
    private int columnCount;

    public void setCellTouchHandler(TouchHandler<UiCell> touchHandler) {
        this.cellTouchHandler = touchHandler;
        for (UiCell[] row : uiCells) {
            for (UiCell cell : row) {
                cell.setTouchHandler(touchHandler);
            }
        }
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
        uiCells = null;
        removeAllChildren();
        if (checkCells(cells)) {
            rowCount = cells.length;
            columnCount = cells[0].length;
        } else {
            rowCount = 0;
            columnCount = 0;
        }

        initCells();
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
        getChildWidgets().clear();
        uiCells = new UiCell[rowCount][columnCount];
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
                cell.setCell(cells[i][j]);
                uiCells[i][j] = cell;
            }
        }

        setCellTouchHandler(cellTouchHandler);
    }

    private boolean checkCells(Cell[][] cells) {
        return cells != null && cells.length > 0 && cells[0].length > 0;
    }
}
