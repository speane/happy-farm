package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Cell;

public class UiCellMenu extends Widget {

    private static final float WIDTH = 300;
    private static final float HEIGHT = 100;
    private static final String TEXTURE = "cell_menu";

    private UiCellMenuItem healItem;
    private static final float HEAL_ITEM_WIDTH = WIDTH / 4;
    private static final float HEAL_ITEM_HEIGHT = HEIGHT / 5 * 4;
    private static final float HEAL_ITEM_X = (WIDTH - HEAL_ITEM_WIDTH * 3) / 4;
    private static final float HEAL_ITEM_Y = HEIGHT / 10;
    private static final String HEAL_ITEM_TEXTURE = "heal_button";

    private UiCellMenuItem feedItem;
    private static final float FEED_ITEM_WIDTH = WIDTH / 4;
    private static final float FEED_ITEM_HEIGHT = HEIGHT / 5 * 4;
    private static final float FEED_ITEM_X = (WIDTH - HEAL_ITEM_WIDTH * 3) / 4 * 2 + HEAL_ITEM_WIDTH;
    private static final float FEED_ITEM_Y = HEIGHT / 10;
    private static final String FEED_ITEM_TEXTURE = "feed_button";

    private UiCellMenuItem swapItem;
    private static final float SWAP_ITEM_WIDTH = WIDTH / 4;
    private static final float SWAP_ITEM_HEIGHT = HEIGHT / 5 * 4;
    private static final float SWAP_ITEM_X = (WIDTH - HEAL_ITEM_WIDTH * 3) / 4 * 3 + HEAL_ITEM_WIDTH * 2;
    private static final float SWAP_ITEM_Y = HEIGHT / 10;
    private static final String SWAP_ITEM_TEXTURE = "swap_button";

    private Cell cell;

    @Override
    protected void init() {
        initUi();
    }

    @Override
    protected float getDefaultWidth() {
        return WIDTH;
    }

    @Override
    protected float getDefaultHeight() {
        return HEIGHT;
    }

    @Override
    protected String getDefaultTextureName() {
        return TEXTURE;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
        healItem.setCell(cell);
        feedItem.setCell(cell);
    }

    public void setHealHandler(TouchHandler touchHandler) {
        healItem.setTouchHandler(touchHandler);
    }

    public void setFeedHandler(TouchHandler touchHandler) {
        feedItem.setTouchHandler(touchHandler);
    }

    public void setSwapHandler(TouchHandler touchHandler) {
        swapItem.setTouchHandler(touchHandler);
    }

    private void initUi() {
        initHealItem();
        initFeedItem();
        initSwapItem();
    }

    private void initHealItem() {
        healItem = new UiCellMenuItem();
        healItem.setTexture(HEAL_ITEM_TEXTURE);
        healItem.setSize(HEAL_ITEM_WIDTH, HEAL_ITEM_HEIGHT);
        healItem.setVisible(true);
        healItem.setTouchable(true);
        appendChild(healItem, HEAL_ITEM_X, HEAL_ITEM_Y);
    }

    private void initFeedItem() {
        feedItem = new UiCellMenuItem();
        feedItem.setTexture(FEED_ITEM_TEXTURE);
        feedItem.setSize(FEED_ITEM_WIDTH, FEED_ITEM_HEIGHT);
        feedItem.setVisible(true);
        feedItem.setTouchable(true);
        appendChild(feedItem, FEED_ITEM_X, FEED_ITEM_Y);
    }

    private void initSwapItem() {
        swapItem = new UiCellMenuItem();
        swapItem.setTexture(SWAP_ITEM_TEXTURE);
        swapItem.setSize(SWAP_ITEM_WIDTH, SWAP_ITEM_HEIGHT);
        swapItem.setVisible(true);
        swapItem.setTouchable(true);
        appendChild(swapItem, SWAP_ITEM_X, SWAP_ITEM_Y);
    }
}
