package com.speane.happyfarm.screen;

import com.speane.happyfarm.HappyFarmGame;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.table.*;

public class MainScreen extends AbstractScreen<UiMainScreenView, HappyFarmGame> {

    public MainScreen(HappyFarmGame game) {
        initGame(game);
        initView();
        initData();
    }

    @Override
    public void gridChanged(Grid grid) {
        getView().setGrid(grid);
    }

    private void initData() {
        gridChanged(getGame().getGrid());
        getView().setScore(getGame().getScore());
    }

    private void initGame(HappyFarmGame game) {
        setGame(game);
    }

    private void initView() {
        setView(new UiMainScreenView());
        initViewTouchHandlers();
    }

    private void initViewTouchHandlers() {
        initExitButtonHandler();
        initCellTouchHandler();
        initCellMenuItemHandlers();
    }

    private void initCellMenuItemHandlers() {
        initCreateItemHandler();
        initRemoveItemHandler();
    }

    private void initCreateItemHandler() {
        getView().setCellMenuItemCreateHandler(new TouchHandler<UiCellMenuItem>() {
            @Override
            public void onTouch(UiCellMenuItem item) {
                getGame().createEntityAtCell(item.getCell());
            }
        });
    }

    private void initRemoveItemHandler() {
        getView().setCellMenuItemRemoveHandler(new TouchHandler<UiCellMenuItem>() {
            @Override
            public void onTouch(UiCellMenuItem item) {
                getGame().removeEntityAtCell(item.getCell());
            }
        });
    }

    private void initCellTouchHandler() {
        getView().setCellTouchHandler(new TouchHandler<UiCell>() {
            @Override
            public void onTouch(UiCell cell) {
                getView().showCellMenu(cell.getCell());
            }
        });
    }

    private void initExitButtonHandler() {
        getView().setExitButtonTouchHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().showStartScreen();
            }
        });
    }
}
