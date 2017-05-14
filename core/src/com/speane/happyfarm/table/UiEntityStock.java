package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.StockEntity;

import java.util.List;

public class UiEntityStock extends Widget {

    private static final float WIDTH = 320;
    private static final float HEIGHT = 240;
    private static final String TEXTURE = "entity_stock";
    private static final int ROW_COUNT = 3;
    private static final int COLUMN_COUNT = 4;

    private Callback<StockEntity> selectCallback;

    public void setSelectCallback(Callback<StockEntity> selectCallback) {
        this.selectCallback = selectCallback;
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

    public void setEntities(List<StockEntity> entities) {
        removeAllChildren();
        if (entities != null && !entities.isEmpty()) {
            int realIndex = 0;
            for (int i = 0; i < entities.size() && i < ROW_COUNT * COLUMN_COUNT; i++) {
                if (entities.get(i).getAmount() > 0) {
                    createStockEntity(entities.get(i), realIndex / COLUMN_COUNT, realIndex % COLUMN_COUNT);
                    realIndex++;
                }
            }
        }
    }

    private void createStockEntity(StockEntity entity, int row, int column) {
        UiStockEntity uiEntity = new UiStockEntity();
        uiEntity.setEntity(entity);
        uiEntity.setVisible(true);
        uiEntity.setTouchable(true);
        uiEntity.setSize(getWidth() / COLUMN_COUNT, getHeight() / ROW_COUNT);
        uiEntity.setTouchHandler(new TouchHandler<UiStockEntity>() {
            @Override
            public void onTouch(UiStockEntity widget) {
                if (selectCallback != null) {
                    selectCallback.execute(widget.getEntity());
                }
            }
        });
        appendChild(uiEntity, column * getWidth() / COLUMN_COUNT,
                (ROW_COUNT - (row + 1)) * getHeight() / ROW_COUNT);
    }
}
