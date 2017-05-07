package com.speane.happyfarm.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.entity.TextureManager;
import com.speane.happyfarm.table.UiCell;
import com.speane.happyfarm.table.Widget;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {

    private TextureManager textureManager;

    private Batch batch;

    private List<Renderable> renderables;

    public Renderer(Batch batch) {
        this.batch = batch;
        renderables = new ArrayList<Renderable>();
        textureManager = new TextureManager();
    }

    public void render(Widget widget) {
        TextureRegion texture = textureManager.getTexture(widget);
        System.out.println(texture);
        if (texture != null) {
            if (widget instanceof UiCell) {
                System.out.println("draw cell");
            }
            batch.draw(
                    texture,
                    widget.getX(),
                    widget.getY(),
                    widget.getWidth(),
                    widget.getHeight());
        }
    }

    public void addRenderable(Renderable renderable) {
        renderables.add(renderable);
    }

    public void render() {
        clearScreen();
        batch.begin();

        for (Renderable renderable : renderables) {
            renderable.render(this);
        }

        batch.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), Color.BLACK.getAlpha());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
