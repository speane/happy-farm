package com.speane.happyfarm.table;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.entity.Entity;
import com.speane.happyfarm.entity.Plant;

public class UiEntity extends Widget {

    private static final float DEFAULT_WIDTH = 128;

    private TextureRegion firstTexture = new TextureRegion(new Texture("test1.png"));
    private TextureRegion secondTexture = new TextureRegion(new Texture("test2.png"));
    private TextureRegion thirdTexture = new TextureRegion(new Texture("test3.png"));

    private Entity entity;

    public Entity getEntity() {
        final Entity entity = new Plant();
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public TextureRegion getTexture() {
        if (entity != null) {
            if (entity.age > 2) {
                return thirdTexture;
            } else if (entity.age > 1) {
                return secondTexture;
            }
        }

        return firstTexture;
    }

    @Override
    protected float getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    protected float getDefaultHeight() {
        return DEFAULT_WIDTH;
    }

    @Override
    protected void init() {
        setTexture(new TextureRegion(new Texture("entity.png")));
    }
}
