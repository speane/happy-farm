package com.speane.happyfarm.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.config.Config;

public class TextureRepository {

    private static TextureAtlas textureAtlas;

    static {
        initTextureAtlas();
    }

    public static TextureRegion getTextureByName(String name) {
        return textureAtlas.findRegion(name);
    }

    private static void initTextureAtlas() {
        textureAtlas = new TextureAtlas(Gdx.files.internal(Config.INSTANCE.getTextureAtlasName()));
    }
}
