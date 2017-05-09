package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Entity;

public abstract class ProgressObserver<T extends Entity> {

    private T entity;

    public ProgressObserver(T entity) {
        this.entity = entity;
    }

    protected T getEntity() {
        return entity;
    }

    public float getProgress() {
        return Math.min(getObservedProgress(), 1);
    }

    protected abstract float getObservedProgress();
}
