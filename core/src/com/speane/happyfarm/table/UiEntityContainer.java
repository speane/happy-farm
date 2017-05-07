package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UiEntityContainer extends Widget {
    
    private static final float PREF_WIDTH = 128;

    public UiEntityContainer() {
        setTexture(new TextureRegion(new Texture("container.png")));
    }

    @Override
    public float getDefaultWidth() {
        return PREF_WIDTH;
    }

    @Override
    public float getDefaultHeight() {
        return PREF_WIDTH;
    }

}
