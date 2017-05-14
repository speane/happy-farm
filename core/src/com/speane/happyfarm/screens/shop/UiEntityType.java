package com.speane.happyfarm.screens.shop;

import com.speane.happyfarm.entity.EntityType;
import com.speane.happyfarm.ui.*;

public class UiEntityType extends Widget {

    private static final float WIDTH = 320;
    private static final float HEIGHT = 240;
    private static final String TEXTURE_NAME = "entity_type";

    private UiImage image;
    private static final float IMAGE_WIDTH = WIDTH / 4;
    private static final float IMAGE_HEIGHT = HEIGHT / 8 * 6;
    private static final float IMAGE_X = WIDTH / 10;
    private static final float IMAGE_Y = HEIGHT / 8;

    private UiLabel priceNameLabel;
    private static final float PRICE_NAME_LABEL_WIDTH = WIDTH / 6;
    private static final float PRICE_NAME_LABEL_X = IMAGE_X * 2 + IMAGE_WIDTH;
    private static final float PRICE_NAME_LABEL_Y = IMAGE_Y + IMAGE_HEIGHT / 2;
    private static final String PRICE_NAME_LABEL_TEXT = "Price:";

    private UiLabel priceValueLabel;
    private static final float PRICE_VALUE_LABEL_X = PRICE_NAME_LABEL_X + PRICE_NAME_LABEL_WIDTH + IMAGE_X;
    private static final float PRICE_VALUE_LABEL_Y = PRICE_NAME_LABEL_Y;

    private EntityType type;

    public void setType(EntityType type) {
        this.type = type;
        updateUi();
    }

    public EntityType getType() {
        return type;
    }

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
        return TEXTURE_NAME;
    }

    private void initUi() {
        initImage();
        initPriceNameLabel();
        initPriceValueLabel();
    }

    private void initImage() {
        image = new UiImage();
        image.setVisible(true);
        image.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
        appendChild(image, IMAGE_X, IMAGE_Y);
    }

    private void initPriceNameLabel() {
        priceNameLabel = new UiLabel();
        priceNameLabel.setVisible(true);
        priceNameLabel.setText(PRICE_NAME_LABEL_TEXT);
        appendChild(priceNameLabel, PRICE_NAME_LABEL_X, PRICE_NAME_LABEL_Y);
    }

    private void initPriceValueLabel() {
        priceValueLabel = new UiLabel();
        priceValueLabel.setVisible(true);
        appendChild(priceValueLabel, PRICE_VALUE_LABEL_X, PRICE_VALUE_LABEL_Y);
    }

    private void updateUi() {
        image.setTexture(type != null ? type.getTextureName() : null);
        priceValueLabel.setText(type != null ? type.getPrice() + "" : "");
    }
}
