package com.speane.happyfarm.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.speane.happyfarm.config.Config;
import com.speane.happyfarm.ui.UiLabel;
import com.speane.happyfarm.ui.UiProgressBarInner;
import com.speane.happyfarm.ui.Widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Renderer {

    private Batch batch;
    private Color backgroundColor;
    private List<Renderable> renderables;
    private Map<Class<? extends Widget>, DrawHandler> drawHandlers;
    private DefaultDrawHandler defaultDrawHandler;

    public Renderer(Batch batch) {
        initBatch(batch);
        initBackgroundColor();
        initRenderables();
        initDrawHandlers();
        initDefaultDrawHandler();
    }

    public void render(Widget widget) {
        if (canBeDrawn(widget)) {
            getDrawHandler(widget.getClass()).draw(batch, widget);
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

    private boolean hasDrawHandler(Class clazz) {
        return drawHandlers.containsKey(clazz);
    }

    private DrawHandler getDefaultDrawHandler() {
        return defaultDrawHandler;
    }

    private DrawHandler getDrawHandlerForClass(Class clazz) {
        return drawHandlers.get(clazz);
    }

    private DrawHandler getDrawHandler(Class clazz) {
        if (hasDrawHandler(clazz)) {
            return getDrawHandlerForClass(clazz);
        } else if (!clazz.equals(Widget.class)){
            return getDrawHandler(clazz.getSuperclass());
        } else {
            return getDefaultDrawHandler();
        }
    }

    private boolean canBeDrawn(Widget widget) {
        return widget != null && widget.isVisible();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(backgroundColor.r, backgroundColor.g, backgroundColor.b, backgroundColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void initBackgroundColor() {
        backgroundColor = Color.valueOf(Config.INSTANCE.getBackgroundColorCode());
    }

    private void initBatch(Batch batch) {
        this.batch = batch;
    }

    private void initRenderables() {
        renderables = new ArrayList<Renderable>();
    }

    private void initDrawHandlers() {
        drawHandlers = new HashMap<Class<? extends Widget>, DrawHandler>();
        drawHandlers.put(UiProgressBarInner.class, new ProgressBarDrawHandler());
        drawHandlers.put(UiLabel.class, new LabelDrawHandler());
    }

    private void initDefaultDrawHandler() {
        defaultDrawHandler = new DefaultDrawHandler();
    }
}
