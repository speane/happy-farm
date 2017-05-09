package com.speane.happyfarm.table;

import com.badlogic.gdx.InputProcessor;
import com.speane.happyfarm.entity.Container;

import java.util.HashMap;
import java.util.Map;

public class UiMainScreenView extends Widget implements MainScreenView, InputProcessor {

    private static final float DEFAULT_WIDTH = 640;
    private static final float DEFAULT_HEIGHT = 640;

    private UiGrid grid;
    private static final float GRID_X = 0;
    private static final float GRID_Y = 0;
    private static final float GRID_WIDTH = DEFAULT_WIDTH;
    private static final float GRID_HEIGHT = DEFAULT_HEIGHT * 10 / 11;

    private UiCellMenu cellMenu;
    private CellMenuManager cellMenuManager;
    private static final float CELL_MENU_WIDTH = DEFAULT_WIDTH * 3 / 4;
    private static final float CELL_MENU_HEIGHT = DEFAULT_HEIGHT / 6;
    private static final float CELL_MENU_X = (DEFAULT_WIDTH - CELL_MENU_WIDTH) / 2;
    private static final float CELL_MENU_Y = DEFAULT_HEIGHT / 4;

    private Map<Class<? extends Widget>, TouchHandler> touchHandlers;


    @Override
    public float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return DEFAULT_HEIGHT;
    }

    @Override
    protected String getDefaultTextureName() {
        return null;
    }

    @Override
    protected void init() {
        initSelf();
        initUi();
        initTouchHandlers();
    }

    @Override
    public void setContainers(Container[][] containers) {
        grid.setContainers(containers);
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("KEY DOWN");
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("TOUCHED");
        for (Widget child : getChildWidgets()) {
            Widget touchedWidget = child.getTouched(screenX, screenY);
            System.out.println(touchedWidget);
            if (touchedWidget != null) {
                if (touchHandlers.containsKey(touchedWidget.getClass())) {
                    touchHandlers.get(touchedWidget.getClass()).onTouch(touchedWidget);

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("TOUCH UP");
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private void initSelf() {
        setTouchable(true);
        setVisible(true);
    }

    private void initUi() {
        initGrid();
        initCellMenu();
    }

    private void initGrid() {
        grid = new UiGrid();
        grid.setSize(GRID_WIDTH, GRID_HEIGHT);
        grid.setVisible(true);
        grid.setTouchable(true);
        appendChild(grid, GRID_X, GRID_Y);
    }

    private void initCellMenu() {
        cellMenu = new UiCellMenu();
        cellMenu.setSize(CELL_MENU_WIDTH, CELL_MENU_HEIGHT);
        cellMenuManager = new CellMenuManager(cellMenu);
        appendChild(cellMenu, CELL_MENU_X, CELL_MENU_Y);
    }

    private void initTouchHandlers() {
        touchHandlers = new HashMap<Class<? extends Widget>, TouchHandler>();
        touchHandlers.put(UiCell.class, new TouchHandler<UiCell>() {
            @Override
            public void onTouch(UiCell cell) {
                System.out.println("TOUCHED");
                if (!cellMenuManager.isShowing()) {
                    cellMenuManager.show();
                } else {
                    cellMenuManager.hide();
                }
            }
        });
    }
}
