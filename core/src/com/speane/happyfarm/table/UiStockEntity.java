package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.StockEntity;

public class UiStockEntity extends Widget {

    private static final float WIDTH = 240;
    private static final float HEIGHT = 320;

    private UiImage image;
    private static final float IMAGE_WIDTH = WIDTH;
    private static final float IMAGE_HEIGHT = WIDTH;
    private static final float IMAGE_X = 0;
    private static final float IMAGE_Y = HEIGHT - IMAGE_HEIGHT;

    private UiValueLabel valueLabel;
    private static final float LABEL_WIDTH = WIDTH;
    private static final float LABEL_HEIGHT = IMAGE_Y;
    private static final float LABEL_X = WIDTH / 2;
    private static final float LABEL_Y = LABEL_HEIGHT / 2;

    private StockEntity entity;

    public void setEntity(StockEntity entity) {
        this.entity = entity;
        apply();
    }

    public StockEntity getEntity() {
        return entity;
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
        return null;
    }

    @Override
    protected void init() {
        initUi();
    }

    private void initUi() {
        initImage();
        initLabel();
    }

    private void initImage() {
        image = new UiImage();
        image.setVisible(true);
        image.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
        appendChild(image, IMAGE_X, IMAGE_Y);
    }

    private void initLabel() {
        valueLabel = new UiValueLabel();
        valueLabel.setVisible(true);
        valueLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        valueLabel.setValueObserver(new ValueObserver<Integer>() {
            @Override
            public Integer getValue() {
                return entity != null ? entity.getAmount() : 0;
            }
        });
        appendChild(valueLabel, LABEL_X, LABEL_Y);
    }

    private void apply() {
        image.setTexture(entity != null && entity.getType() != null ? entity.getType().getTextureName() : null);
    }
}
