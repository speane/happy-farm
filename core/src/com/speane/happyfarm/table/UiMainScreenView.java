package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.entity.StockEntity;
import com.speane.happyfarm.screen.AbstractView;

import java.util.List;

public class UiMainScreenView extends AbstractView implements MainScreenView {

    private static final float DEFAULT_WIDTH = 640;
    private static final float DEFAULT_HEIGHT = 640;

    private UiGrid grid;
    private static final float GRID_X = 0;
    private static final float GRID_Y = 0;
    private static final float GRID_WIDTH = DEFAULT_WIDTH;
    private static final float GRID_HEIGHT = DEFAULT_HEIGHT * 10 / 11;
    private TouchHandler<UiCell> cellTouchHandler;

    private UiCellMenu cellMenu;
    private CellMenuManager cellMenuManager;
    private static final float CELL_MENU_WIDTH = DEFAULT_WIDTH * 3 / 4;
    private static final float CELL_MENU_HEIGHT = DEFAULT_HEIGHT / 6;
    private static final float CELL_MENU_X = (DEFAULT_WIDTH - CELL_MENU_WIDTH) / 2;
    private static final float CELL_MENU_Y = DEFAULT_HEIGHT / 7 * 3;

    private UiLabel scoreLabel;
    private static final float SCORE_LABEL_WIDTH = 70;
    private static final float SCORE_LABEL_X = DEFAULT_WIDTH / 6 * 5;
    private static final float SCORE_LABEL_Y = DEFAULT_HEIGHT / 30 * 29;

    private UiValueLabel scoreValueLabel;
    private static final float SCORE_VALUE_LABEL_X = SCORE_LABEL_X + SCORE_LABEL_WIDTH;
    private static final float SCORE_VALUE_LABEL_Y = SCORE_LABEL_Y;

    private UiButton exitButton;
    private static final float EXIT_BUTTON_WIDTH = DEFAULT_WIDTH / 6;
    private static final float EXIT_BUTTON_HEIGHT = DEFAULT_HEIGHT / 20;
    private static final float EXIT_BUTTON_X = 0;
    private static final float EXIT_BUTTON_Y = DEFAULT_HEIGHT - EXIT_BUTTON_HEIGHT;
    private static final String EXIT_BUTTON_TEXTURE = "exit_button";

    private UiEntityStock entityStock;
    private static final float ENTITY_STOCK_WIDTH = DEFAULT_WIDTH / 5 * 4;
    private static final float ENTITY_STOCK_HEIGHT = DEFAULT_HEIGHT / 5 * 3;
    private static final float ENTITY_STOCK_X = DEFAULT_WIDTH / 10;
    private static final float ENTITY_STOCK_Y = DEFAULT_HEIGHT / 9 * 2;

    private UiButton shopButton;
    private static final float SHOP_BUTTON_WIDTH = DEFAULT_WIDTH / 6;
    private static final float SHOP_BUTTON_HEIGHT = DEFAULT_HEIGHT / 20;
    private static final float SHOP_BUTTON_X = DEFAULT_WIDTH / 2;
    private static final float SHOP_BUTTON_Y = DEFAULT_HEIGHT - SHOP_BUTTON_HEIGHT;
    private static final String SHOP_BUTTON_TEXTURE = "shop_button";

    private UiMenu menu;
    private static final float MENU_WIDTH = DEFAULT_WIDTH / 3 * 2;
    private static final float MENU_HEIGHT = DEFAULT_HEIGHT / 3;
    private static final float MENU_X = (DEFAULT_WIDTH - MENU_WIDTH) / 2;
    private static final float MENU_Y = (DEFAULT_HEIGHT - MENU_HEIGHT) / 2;

    private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

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
    }

    @Override
    public void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler) {
        exitButton.setTouchHandler(touchHandler);
    }

    @Override
    public void setShopButtonTouchHandler(TouchHandler<UiButton> touchHandler) {
        shopButton.setTouchHandler(touchHandler);
    }

    @Override
    public void setGrid(Grid grid) {
        if (grid != null) {
            this.grid.setCells(grid.getCells());
        }
    }

    @Override
    public void showCellMenu(Cell cell) {
        cellMenu.setCell(cell);
        showModal(cellMenu);
    }

    @Override
    public void showSelectEntityPopup(final Callback<StockEntity> callback) {
        entityStock.setSelectCallback(new Callback<StockEntity>() {
            @Override
            public void execute(StockEntity entity) {
                if (callback != null) {
                    callback.execute(entity);
                }
            }
        });

        showModal(entityStock);
    }

    @Override
    public void hideCellMenu() {
        cellMenuManager.hide();
    }

    @Override
    public void setCellMenuHealItemTouchHandler(TouchHandler<UiCellMenuItem> handler) {
        cellMenu.setHealHandler(handler);
    }

    @Override
    public void setCellMenuFeedItemTouchHandler(TouchHandler<UiCellMenuItem> handler) {
        cellMenu.setFeedHandler(handler);
    }

    @Override
    public void setCellMenuSwapItemTouchHandler(TouchHandler<UiCellMenuItem> handler) {
        cellMenu.setSwapHandler(handler);
    }

    @Override
    public void setCellTouchHandler(TouchHandler<UiCell> touchHandler) {
        this.cellTouchHandler = touchHandler;
        grid.setCellTouchHandler(touchHandler);
    }

    @Override
    public void setStockEntities(List<StockEntity> entities) {
        entityStock.setEntities(entities);
    }

    @Override
    public void showMenu() {
        showModal(menu);
    }

    @Override
    public void setMenuSaveButtonHandler(TouchHandler<UiButton> touchHandler) {
        menu.setSaveButtonHandler(touchHandler);
    }

    @Override
    public void setMenuExitButtonHandler(TouchHandler<UiButton> touchHandler) {
        menu.setExitButtonHandler(touchHandler);
    }

    private void initSelf() {
        setTouchable(true);
        setVisible(true);
    }

    private void initUi() {
        initGrid();
        initCellMenu();
        initScoreLabel();
        initScoreValueLabel();
        initExitButton();
        initEntityStock();
        initShopButton();
        initMenu();
    }

    private void initGrid() {
        grid = new UiGrid();
        grid.setSize(GRID_WIDTH, GRID_HEIGHT);
        grid.setVisible(true);
        grid.setTouchable(true);
        grid.setCellTouchHandler(cellTouchHandler);
        appendChild(grid, GRID_X, GRID_Y);
    }

    private void initScoreLabel() {
        scoreLabel = new UiLabel();
        BitmapFont font = new BitmapFont();
        scoreLabel.setFont(font);
        scoreLabel.setVisible(true);
        scoreLabel.setText("SCORE");
        appendChild(scoreLabel, SCORE_LABEL_X, SCORE_LABEL_Y);
    }

    private void initScoreValueLabel() {
        scoreValueLabel = new UiValueLabel();
        BitmapFont font = new BitmapFont();
        scoreValueLabel.setFont(font);
        scoreValueLabel.setVisible(true);
        scoreValueLabel.setValueObserver(new ValueObserver<Integer>() {
            @Override
            public Integer getValue() {
                return getScore() != null ? getScore().getValue() : 0;
            }
        });
        appendChild(scoreValueLabel, SCORE_VALUE_LABEL_X, SCORE_VALUE_LABEL_Y);
    }

    private void initCellMenu() {
        cellMenu = new UiCellMenu();
        cellMenu.setSize(CELL_MENU_WIDTH, CELL_MENU_HEIGHT);
        cellMenuManager = new CellMenuManager(cellMenu);
        cellMenu.setTouchable(true);
        appendChild(cellMenu, CELL_MENU_X, CELL_MENU_Y);
    }

    private void initExitButton() {
        exitButton = new UiButton();
        exitButton.setVisible(true);
        exitButton.setTouchable(true);
        exitButton.setTexture(EXIT_BUTTON_TEXTURE);
        exitButton.setSize(EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        appendChild(exitButton, EXIT_BUTTON_X, EXIT_BUTTON_Y);
    }

    private void initEntityStock() {
        entityStock = new UiEntityStock();
        entityStock.setTouchable(true);
        entityStock.setSize(ENTITY_STOCK_WIDTH, ENTITY_STOCK_HEIGHT);
        appendChild(entityStock, ENTITY_STOCK_X, ENTITY_STOCK_Y);
    }

    private void initShopButton() {
        shopButton = new UiButton();
        shopButton.setVisible(true);
        shopButton.setTouchable(true);
        shopButton.setTexture(SHOP_BUTTON_TEXTURE);
        shopButton.setSize(SHOP_BUTTON_WIDTH, SHOP_BUTTON_HEIGHT);
        appendChild(shopButton, SHOP_BUTTON_X, SHOP_BUTTON_Y);
    }

    private void initMenu() {
        menu = new UiMenu();
        menu.setTouchable(true);
        menu.setSize(MENU_WIDTH, MENU_HEIGHT);
        appendChild(menu, MENU_X, MENU_Y);
    }
}
