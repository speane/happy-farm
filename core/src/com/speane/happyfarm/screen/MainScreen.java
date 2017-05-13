package com.speane.happyfarm.screen;

import com.speane.happyfarm.HappyFarmGame;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.entity.StockEntity;
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
        getView().setStockEntities(getGame().getStockEntities());
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
        initShopButtonTouchHandler();
        initCellMenuItemHandlers();
        initMenuSaveButtonHandler();
        initMenuExitButtonHandler();
    }

    private void initCellMenuItemHandlers() {
        initCellMenuHealItemTouchHandler();
        initCellMenuFeedItemTouchHandler();
    }

    private void initCellMenuHealItemTouchHandler() {
        getView().setCellMenuHealItemTouchHandler(new TouchHandler<UiCellMenuItem>() {
            @Override
            public void onTouch(UiCellMenuItem item) {
                getGame().healCell(item.getCell());
            }
        });
    }

    private void initCellMenuFeedItemTouchHandler() {
        getView().setCellMenuFeedItemTouchHandler(new TouchHandler<UiCellMenuItem>() {
            @Override
            public void onTouch(UiCellMenuItem item) {
                getGame().feedCell(item.getCell());
            }
        });
    }

    private void initCellTouchHandler() {
        getView().setCellTouchHandler(new TouchHandler<UiCell>() {
            @Override
            public void onTouch(final UiCell uiCell) {
                if (uiCell.getCell() != null && uiCell.getCell().getContainer() != null) {
                    if (uiCell.getCell().getContainer().getEntity() != null) {
                        if (uiCell.getCell().getContainer().getEntity().isReady()) {
                            getGame().takeResultFromCell(uiCell.getCell());
                        } else {
                            getView().showCellMenu(uiCell.getCell());
                        }
                    } else {
                        getView().showSelectEntityPopup(new Callback<StockEntity>() {
                            @Override
                            public void execute(StockEntity object) {
                                getGame().createEntityAtCell(uiCell.getCell(), object.getType());
                            }
                        });
                    }
                }
            }
        });
    }

    private void initExitButtonHandler() {
        getView().setExitButtonTouchHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getView().showMenu();
            }
        });
    }

    private void initShopButtonTouchHandler() {
        getView().setShopButtonTouchHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().showEntityShopScreen();
            }
        });
    }

    private void initMenuSaveButtonHandler() {
        getView().setMenuSaveButtonHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().save();
            }
        });
    }

    private void initMenuExitButtonHandler() {
        getView().setMenuExitButtonHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().showStartScreen();
            }
        });
    }
}
