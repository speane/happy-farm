package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Container;

import java.util.List;

public class UiMainScreenView extends Widget implements MainScreenView {

    private static final float PREF_WIDTH = 640;
    private static final float PREF_HEIGHT = 640;

    private UiGrid grid;
    private static final float GRID_X = 0;
    private static final float GRID_Y = 0;
    private static final float GRID_WIDTH = 640;
    private static final float GRID_HEIGHT = 640;

    private List<Widget> widgets;

    @Override
    public float getDefaultWidth() {
        return PREF_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return PREF_HEIGHT;
    }

    @Override
    protected void init() {
        System.out.println("INIT VIEW");
        grid = new UiGrid();
        grid.setSize(GRID_WIDTH, GRID_HEIGHT);
        appendChild(grid, GRID_X, GRID_Y);
    }

    @Override
    public void setContainers(Container[][] containers) {
        grid.setContainers(containers);
    }
}
