package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.entity.Container;

public class UiGrid extends UiWrapper {

    private static final float DEFAULT_WIDTH = 384;
    private static final float DEFAULT_BORDER_OFFSET = 5;

    private Container[][] containers;

    private UiCell[][] cells;

    private int rowCount;
    private int columnCount;

    @Override
    public float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return DEFAULT_WIDTH;
    }

    public void setContainers(Container[][] containers) {
        System.out.println("set");
        if (containersAreCorrect(containers)) {
            System.out.println("Correct");
            this.containers = containers;
            rowCount = containers.length;
            columnCount = containers[0].length;
            initCells();
        }
    }

    @Override
    protected void init() {
        System.out.println("INIT");
        setTexture(new TextureRegion(new Texture("table.png")));
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
        System.out.println(rowCount + " " + columnCount);
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

    private boolean containersAreCorrect(Container[][] containers) {
        return containers != null && containers.length > 0 && containers[0] != null && containers[0].length > 0;
    }
}
