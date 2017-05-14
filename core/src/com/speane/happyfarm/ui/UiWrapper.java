package com.speane.happyfarm.ui;

public abstract class UiWrapper extends Widget {

    protected float getInnerAreaWidth() {
        return getWidth() - getHorizontalOffset() * 2;
    }

    protected float getInnerAreaHeight() {
        return getHeight() - getVerticalOffset() * 2;
    }

    protected float getHorizontalOffset() {
        return getHorizontalOffsetRatio() * getWidth();
    }

    protected float getVerticalOffset() {
        return getVerticalOffsetRatio() * getHeight();
    }

    protected float getHorizontalOffsetRatio() {
        return getDefaultHorizontalBorderOffset() / getDefaultWidth();
    }

    protected float getVerticalOffsetRatio() {
        return getDefaultVerticalBorderOffset() / getDefaultHeight();
    }

    protected abstract float getDefaultHorizontalBorderOffset();

    protected abstract float getDefaultVerticalBorderOffset();
}
