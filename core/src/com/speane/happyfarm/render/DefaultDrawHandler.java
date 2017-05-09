package com.speane.happyfarm.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.speane.happyfarm.table.Widget;

public class DefaultDrawHandler implements DrawHandler {

    @Override
    public void draw(Batch batch, Widget widget) {
        if (widget != null && widget.getTexture() != null) {
            batch.draw(
                    widget.getTexture(),
                    widget.getX(), widget.getY(),
                    widget.getWidth(), widget.getHeight());
        }
    }
}
