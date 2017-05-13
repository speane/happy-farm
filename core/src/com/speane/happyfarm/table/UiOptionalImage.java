package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

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
