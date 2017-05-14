package com.speane.happyfarm.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.ui.observer.ValueObserver;

public class UiOptionalImage extends UiImage {

    private ValueObserver<Boolean> showObserver;

    public void setShowObserver(ValueObserver<Boolean> showObserver) {
        this.showObserver = showObserver;
    }

    @Override
    public TextureRegion getTexture() {
        return showObserver != null && showObserver.getValue() ? super.getTexture() : null;
    }
}
