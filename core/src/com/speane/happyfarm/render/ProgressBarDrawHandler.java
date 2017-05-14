package com.speane.happyfarm.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.speane.happyfarm.ui.UiProgressBarInner;

public class ProgressBarDrawHandler implements DrawHandler<UiProgressBarInner> {

    @Override
    public void draw(Batch batch, UiProgressBarInner widget) {
        if (widget != null && widget.getTexture() != null) {
            batch.draw(
                    widget.getTexture(),
                    widget.getX(), widget.getY(),
                    widget.getCurrentWidth(), widget.getHeight());
        }
    }
}
