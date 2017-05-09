package com.speane.happyfarm.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.speane.happyfarm.table.Widget;

public interface DrawHandler<T extends Widget> {

    void draw(Batch batch, T widget);
}
