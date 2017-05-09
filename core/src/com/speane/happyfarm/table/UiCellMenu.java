package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Cell;

public class UiCellMenu extends Widget {

    private static final float DEFAULT_WIDTH = 300;
    private static final float DEFAULT_HEIGHT = 100;
    private static final String DEFAULT_TEXTURE_NAME = "cell_menu";

    private UiCellMenuItem createItem;
    private static final float CREATE_ITEM_WIDTH = DEFAULT_WIDTH / 3;
    private static final float CREATE_ITEM_HEIGHT = DEFAULT_HEIGHT / 5 * 4;
    private static final float CREATE_ITEM_X = (DEFAULT_WIDTH - CREATE_ITEM_WIDTH * 2) / 3;
    private static final float CREATE_ITEM_Y = DEFAULT_HEIGHT / 10;
    private static final String CREATE_ITEM_TEXTURE_NAME = "create_menu_item";

    private UiCellMenuItem removeItem;
    private static final float REMOVE_ITEM_WIDTH = DEFAULT_WIDTH / 3;
    private static final float REMOVE_ITEM_HEIGHT = DEFAULT_HEIGHT / 5 * 4;
    private static final float REMOVE_ITEM_X = (DEFAULT_WIDTH - CREATE_ITEM_WIDTH * 2) / 3 * 2 + CREATE_ITEM_WIDTH;
    private static final float REMOVE_ITEM_Y = DEFAULT_HEIGHT / 10;
    private static final String REMOVE_ITEM_TEXTURE_NAME = "remove_menu_item";

    private Cell cell;

    @Override
    protected void init() {
        initUi();
    }

    @Override
    protected float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    protected float getDefaultHeight() {
        return DEFAULT_HEIGHT;
    }

    @Override
    protected String getDefaultTextureName() {
        return DEFAULT_TEXTURE_NAME;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
        createItem.setCell(cell);
        removeItem.setCell(cell);
    }

    public void setCreateHandler(TouchHandler touchHandler) {
        createItem.setTouchHandler(touchHandler);
    }

    public void setRemoveHandler(TouchHandler touchHandler) {
        removeItem.setTouchHandler(touchHandler);
    }

    private void initUi() {
        initCreateItem();
        initRemoveItem();
    }

    private void initCreateItem() {
        createItem = new UiCellMenuItem();
        createItem.setTexture(CREATE_ITEM_TEXTURE_NAME);
        createItem.setSize(CREATE_ITEM_WIDTH, CREATE_ITEM_HEIGHT);
        createItem.setVisible(true);
        createItem.setTouchable(true);
        appendChild(createItem, CREATE_ITEM_X, CREATE_ITEM_Y);
    }

    private void initRemoveItem() {
        removeItem = new UiCellMenuItem();
        removeItem.setTexture(REMOVE_ITEM_TEXTURE_NAME);
        removeItem.setSize(REMOVE_ITEM_WIDTH, REMOVE_ITEM_HEIGHT);
        removeItem.setVisible(true);
        removeItem.setTouchable(true);
        appendChild(removeItem, REMOVE_ITEM_X, REMOVE_ITEM_Y);
    }
}
