package com.speane.happyfarm.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureRepository {

    private static final String ATLAS_FILENAME_PROPERTY_NAME = "texture_atlas_filename";

    private static TextureAtlas textureAtlas;

    static {
        initTextureAtlas();
    }

    public static TextureRegion getTextureByName(String name) {
        return textureAtlas.findRegion(name);
    }

    private static void initTextureAtlas() {
        textureAtlas = new TextureAtlas(Gdx.files.internal(AppConfig.getStringProperty(ATLAS_FILENAME_PROPERTY_NAME)));
    }
}
