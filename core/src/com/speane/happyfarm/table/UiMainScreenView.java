package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.screen.AbstractView;

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
    public void hideCellMenu() {
        cellMenuManager.hide();
    }

    @Override
    public void setCellMenuItemCreateHandler(TouchHandler<UiCellMenuItem> handler) {
        cellMenu.setCreateHandler(handler);
    }

    @Override
    public void setCellMenuItemRemoveHandler(TouchHandler<UiCellMenuItem> handler) {
        cellMenu.setRemoveHandler(handler);
    }

    @Override
    public void setCellTouchHandler(TouchHandler<UiCell> touchHandler) {
        this.cellTouchHandler = touchHandler;
        grid.setCellTouchHandler(touchHandler);
    }

    @Override
    public boolean keyDown(int keycode) {
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
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
        initScoreLabel();
        initScoreValueLabel();
        initExitButton();
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
        scoreValueLabel.setValueObserver(new ValueObserver<Integer, Score>(score) {
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
        exitButton.setSize(EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        appendChild(exitButton, EXIT_BUTTON_X, EXIT_BUTTON_Y);
    }
}
