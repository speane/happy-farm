package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.entity.StockEntity;

import java.util.List;

public interface MainScreenView {

    void setScore(Score score);
    void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setShopButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setGrid(Grid grid);
    void showCellMenu(Cell cell);
    void showSelectEntityPopup(Callback<StockEntity> callback);
    void hideCellMenu();
    void setCellMenuHealItemTouchHandler(TouchHandler<UiCellMenuItem> handler);
    void setCellMenuFeedItemTouchHandler(TouchHandler<UiCellMenuItem> handler);
    void setCellMenuSwapItemTouchHandler(TouchHandler<UiCellMenuItem> handler);
    void setCellTouchHandler(TouchHandler<UiCell> touchHandler);
    void setStockEntities(List<StockEntity> entities);
    void showMenu();
    void setMenuSaveButtonHandler(TouchHandler<UiButton> touchHandler);
    void setMenuExitButtonHandler(TouchHandler<UiButton> touchHandler);
}
