package com.speane.happyfarm.screen.entityshop;

import com.speane.happyfarm.entity.EntityType;
import com.speane.happyfarm.table.TouchHandler;
import com.speane.happyfarm.table.Widget;

import java.util.ArrayList;
import java.util.List;

public class UiEntityTable extends Widget {

    private static final int ROW_COUNT = 6;
    private static final int COLUMN_COUNT = 2;

    private static final float WIDTH = 640;
    private static final float HEIGHT = 480;
    private static final String TEXTURE_NAME = "entity_shop_table";

    private List<UiEntityType> uiEntityTypes;

    public void setTypes(List<EntityType> types) {
        initEntityTypeCells(types);
    }

    public void setEntityTypeTouchHandler(TouchHandler<UiEntityType> handler) {
        for (UiEntityType uiType : uiEntityTypes) {
            uiType.setTouchHandler(handler);
        }
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
        return TEXTURE_NAME;
    }

    private void initEntityTypeCells(List<EntityType> types) {
        removeAllChildren();
        uiEntityTypes = new ArrayList<UiEntityType>();
        for (int i = 0; i < types.size() && i < ROW_COUNT * COLUMN_COUNT; i++) {
            createTypeCell(types.get(i), i / COLUMN_COUNT, i % COLUMN_COUNT);
        }
    }

    private void createTypeCell(EntityType type, int row, int column) {
        UiEntityType uiType = new UiEntityType();
        uiType.setVisible(true);
        uiType.setTouchable(true);
        uiType.setSize(getWidth() / COLUMN_COUNT,  getHeight() / ROW_COUNT);
        uiType.setType(type);
        uiEntityTypes.add(uiType);
        appendChild(uiType, getWidth() / COLUMN_COUNT * column, (getHeight() - getHeight() / ROW_COUNT * (row + 1)));
    }
}
