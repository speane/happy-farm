package com.speane.happyfarm.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.table.UiEntity;
import com.speane.happyfarm.table.Widget;

import java.util.HashMap;
import java.util.Map;

public class TextureManager {

    private Map<Class<? extends Widget>, TextureSource> textureSources;

    public TextureManager() {
        textureSources = new HashMap<Class<? extends Widget>, TextureSource>();
        textureSources.put(UiEntity.class, new EntityTextureSource());
    }

    public TextureRegion getTexture(Widget widget) {
        if (textureSources.containsKey(widget.getClass())) {
            TextureSource textureSource = textureSources.get(widget.getClass());
            if (textureSource != null) {
                return textureSource.getTexture(widget);
            }
        }

        return null;
    }
}
