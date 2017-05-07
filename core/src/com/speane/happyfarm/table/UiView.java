package com.speane.happyfarm.table;

import java.util.List;

public class UiView extends Widget implements View {

    private static final float PREF_WIDTH = 640;
    private static final float PREF_HEIGHT = 640;

    private UiGrid grid;
    private static final float GRID_X = 100;
    private static final float GRID_Y = 100;
    private static final float GRID_WIDTH = 220;
    private static final float GRID_HEIGHT = 220;

    private List<Widget> widgets;

    public UiView() {
        initWidgets();
    }

    @Override
    public float getDefaultWidth() {
        return PREF_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return PREF_HEIGHT;
    }

    private void initWidgets() {
        grid = new UiGrid(3, 3);
        grid.setSize(GRID_WIDTH, GRID_HEIGHT);
        appendChild(grid, GRID_X, GRID_Y);
    }
}
