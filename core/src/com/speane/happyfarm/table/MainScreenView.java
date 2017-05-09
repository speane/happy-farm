package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.entity.Grid;

public interface MainScreenView {

    void setScore(Score score);
    void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setGrid(Grid grid);
    void showCellMenu(Cell cell);
    void hideCellMenu();
    void setCellMenuItemCreateHandler(TouchHandler<UiCellMenuItem> handler);
    void setCellMenuItemRemoveHandler(TouchHandler<UiCellMenuItem> handler);
    void setCellTouchHandler(TouchHandler<UiCell> touchHandler);
}
