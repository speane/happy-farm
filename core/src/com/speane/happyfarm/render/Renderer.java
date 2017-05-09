package com.speane.happyfarm.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.speane.happyfarm.entity.TextureNameRepository;
import com.speane.happyfarm.entity.TextureRepository;
import com.speane.happyfarm.table.UiProgressBarInner;
import com.speane.happyfarm.table.Widget;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Renderer {

    private TextureRepository textureRepository;
    private TextureNameRepository textureNameRepository;

    private Batch batch;

    private List<Renderable> renderables;

    private Map<Class<? extends Widget>, DrawHandler> drawHandlers;
    private DefaultDrawHandler defaultDrawHandler;

    public Renderer(Batch batch) {
        initBatch(batch);
        initRenderables();
        initDrawHandlers();
        initTextureRepository();
        initTextureNameRepository();
        initDefaultDrawHandler();
    }

    public void render(Widget widget) {
        System.out.println("render " + widget.getClass());
        if (canBeDrawn(widget)) {
            getDrawHandler(widget).draw(batch, widget);
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

    private boolean hasDrawHandler(Widget widget) {
        return drawHandlers.containsKey(widget.getClass());
    }

    private DrawHandler getDefaultDrawHandler() {
        return defaultDrawHandler;
    }

    private DrawHandler getDrawHandlerForWidget(Widget widget) {
        return drawHandlers.get(widget.getClass());
    }

    private DrawHandler getDrawHandler(Widget widget) {
        if (hasDrawHandler(widget)) {
            return getDrawHandlerForWidget(widget);
        } else {
            return getDefaultDrawHandler();
        }
    }

    private boolean canBeDrawn(Widget widget) {
        return widget != null && widget.isVisible() && widget.getTexture() != null;
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(
                Color.WHITE.getRed(), Color.WHITE.getGreen(), Color.WHITE.getBlue(),
                Color.WHITE.getAlpha());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void initBatch(Batch batch) {
        this.batch = batch;
    }

    private void initRenderables() {
        renderables = new ArrayList<Renderable>();
    }

    private void initTextureRepository() {
        textureRepository = new TextureRepository();
    }

    private void initDrawHandlers() {
        drawHandlers = new HashMap<Class<? extends Widget>, DrawHandler>();
        drawHandlers.put(UiProgressBarInner.class, new ProgressBarDrawHandler());
    }

    private void initTextureNameRepository() {
        textureNameRepository = new TextureNameRepository();
    }

    private void initDefaultDrawHandler() {
        defaultDrawHandler = new DefaultDrawHandler();
    }
}
