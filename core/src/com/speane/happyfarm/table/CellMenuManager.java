package com.speane.happyfarm.table;

public class CellMenuManager {

    private UiCellMenu cellMenu;

    public CellMenuManager(UiCellMenu cellMenu) {
        this.cellMenu = cellMenu;
    }

    public boolean isShowing() {
        return cellMenu.isVisible();
    }

    public void show() {
        cellMenu.setVisible(true);
    }

    public void hide() {
        cellMenu.setVisible(false);
    }
}
