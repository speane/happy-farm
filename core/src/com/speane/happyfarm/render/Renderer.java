package com.speane.happyfarm.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.speane.happyfarm.table.Widget;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {

    private Batch batch;

    private List<Renderable> renderables;

    public Renderer(Batch batch) {
        this.batch = batch;
        renderables = new ArrayList<Renderable>();
    }

    public void render(Widget widget) {
        if (widget.getTexture() != null) {
            batch.draw(
                    widget.getTexture(),
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
