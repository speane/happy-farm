package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Entity;

public class UiEntity extends Widget {

    private static final float DEFAULT_WIDTH = 128;
    private static final String DEFAULT_TEXTURE_NAME = "entity";

    private Entity entity;

    private UiProgressBar progressBar;
    private static final float PROGRESS_BAR_X = 14;
    private static final float PROGRESS_BAR_Y = 14;
    private static final float PROGRESS_BAR_WIDTH = 100;
    private static final float PROGRESS_BAR_HEIGHT = 20;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
        progressBar.setProgressObserver(new ProgressObserver<Entity>(entity) {
            @Override
            public float getObservedProgress() {
                if (getEntity() != null) {
                    return getEntity().getAge() / getEntity().getMaxAge();
                } else {
                    return 0;
                }
            }
        });
    }

    @Override
    protected void init() {
        progressBar = new UiProgressBar();
        progressBar.setSize(PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT);
        progressBar.setVisible(true);

        appendChild(progressBar, PROGRESS_BAR_X, PROGRESS_BAR_Y);
    }

    @Override
    protected float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    protected float getDefaultHeight() {
        return DEFAULT_WIDTH;
    }

    @Override
    protected String getDefaultTextureName() {
        return DEFAULT_TEXTURE_NAME;
    }
}
