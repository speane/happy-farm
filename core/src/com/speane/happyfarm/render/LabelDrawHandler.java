package com.speane.happyfarm.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.speane.happyfarm.table.UiLabel;

public class LabelDrawHandler implements DrawHandler<UiLabel> {

    @Override
    public void draw(Batch batch, UiLabel widget) {
        if (widget != null && widget.getFont() != null) {
            widget.getFont().draw(
                    batch,
                    widget.getText(),
                    widget.getX(), widget.getY());
        }
    }
}
