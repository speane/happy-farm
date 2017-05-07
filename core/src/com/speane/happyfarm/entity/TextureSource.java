package com.speane.happyfarm.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.table.Widget;

public interface TextureSource<T extends Widget> {

    TextureRegion getTexture(T widget);
}
