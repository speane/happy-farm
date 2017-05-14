package com.speane.happyfarm.ui;

import com.speane.happyfarm.entity.Entity;
import com.speane.happyfarm.ui.observer.ValueObserver;

public class UiEntity extends Widget {

    private static final float WIDTH = 128;
    private static final String DEFAULT_TEXTURE_NAME = "entity";

    private Entity entity;

    private UiOptionalImage resultImage;
    private static final float RESULT_IMAGE_WIDTH = WIDTH / 6;
    private static final float RESULT_IMAGE_HEIGHT = WIDTH / 6;
    private static final float RESULT_IMAGE_X = 0;
    private static final float RESULT_IMAGE_Y = WIDTH - RESULT_IMAGE_WIDTH;
    private static final String RESULT_TEXTURE_NAME = "result_image";

    private UiProgressBar readinessBar;
    private static final float READINESS_BAR_X = 0;
    private static final float READINESS_BAR_Y = WIDTH / 10;
    private static final float READINESS_BAR_WIDTH = WIDTH;
    private static final float READINESS_BAR_HEIGHT = WIDTH / 20;
    private static final String READINESS_BAR_TEXTURE = "readiness_bar";

    private UiProgressBar healthBar;
    private static final float HEALTH_BAR_WIDTH = READINESS_BAR_WIDTH;
    private static final float HEALTH_BAR_HEIGHT = READINESS_BAR_HEIGHT;
    private static final float HEALTH_BAR_X = READINESS_BAR_X;
    private static final float HEALTH_BAR_Y = READINESS_BAR_Y - READINESS_BAR_HEIGHT;
    private static final String HEALTH_BAR_TEXTURE = "health_bar";

    private UiProgressBar satietyBar;
    private static final float SATIETY_BAR_WIDTH = READINESS_BAR_WIDTH;
    private static final float SATIETY_BAR_HEIGHT = READINESS_BAR_HEIGHT;
    private static final float SATIETY_BAR_X = READINESS_BAR_X;
    private static final float SATIETY_BAR_Y = HEALTH_BAR_Y - HEALTH_BAR_HEIGHT;
    private static final String SATIETY_BAR_TEXTURE = "satiety_bar";

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
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
        return WIDTH;
    }

    @Override
    protected String getDefaultTextureName() {
        return DEFAULT_TEXTURE_NAME;
    }

    private void initUi() {
        initReadinessBar();
        initHealthBar();
        initSatietyBar();
        initResultImage();
    }

    private void initReadinessBar() {
        readinessBar = new UiProgressBar();
        readinessBar.setVisible(true);
        readinessBar.setProgressBarTexture(READINESS_BAR_TEXTURE);
        readinessBar.setSize(READINESS_BAR_WIDTH, READINESS_BAR_HEIGHT);
        readinessBar.setValueObserver(new ValueObserver<Float>() {
            @Override
            public Float getValue() {
                return entity != null ? entity.getReadiness() : null;
            }
        });

        appendChild(readinessBar, READINESS_BAR_X, READINESS_BAR_Y);
    }

    private void initHealthBar() {
        healthBar = new UiProgressBar();
        healthBar.setVisible(true);
        healthBar.setProgressBarTexture(HEALTH_BAR_TEXTURE);
        healthBar.setSize(HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT);
        healthBar.setValueObserver(new ValueObserver<Float>() {
            @Override
            public Float getValue() {
                return entity != null ? entity.getHealth() : null;
            }
        });

        appendChild(healthBar, HEALTH_BAR_X, HEALTH_BAR_Y);
    }

    private void initSatietyBar() {
        satietyBar = new UiProgressBar();
        satietyBar.setVisible(true);
        satietyBar.setProgressBarTexture(SATIETY_BAR_TEXTURE);
        satietyBar.setSize(SATIETY_BAR_WIDTH, SATIETY_BAR_HEIGHT);
        satietyBar.setValueObserver(new ValueObserver<Float>() {
            @Override
            public Float getValue() {
                return entity != null ? entity.getSatiety() : null;
            }
        });

        appendChild(satietyBar, SATIETY_BAR_X, SATIETY_BAR_Y);
    }

    private void initResultImage() {
        resultImage = new UiOptionalImage();
        resultImage.setVisible(true);
        resultImage.setSize(RESULT_IMAGE_WIDTH, RESULT_IMAGE_HEIGHT);
        resultImage.setTexture(RESULT_TEXTURE_NAME);
        resultImage.setShowObserver(new ValueObserver<Boolean>() {
            @Override
            public Boolean getValue() {
                return entity != null && entity.isReady();
            }
        });
        appendChild(resultImage, RESULT_IMAGE_X, RESULT_IMAGE_Y);
    }
}
