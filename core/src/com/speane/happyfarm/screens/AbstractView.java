package com.speane.happyfarm.screens;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.speane.happyfarm.config.Config;
import com.speane.happyfarm.render.Renderable;
import com.speane.happyfarm.render.Renderer;
import com.speane.happyfarm.ui.Widget;

public abstract class AbstractView extends Widget implements InputProcessor, Renderable {

    protected static final float WIDTH = Config.INSTANCE.getScreenWidth();
    protected static final float HEIGHT = Config.INSTANCE.getScreenHeight();

    private Renderer renderer;

    private Widget modalWidget;

    public AbstractView() {
        initSelf();
        initRenderer();
    }

    public void render() {
        renderer.render();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (modalWidget != null && !modalWidget.isTouched(screenX, getHeight() - screenY)) {
            hideModal(modalWidget);
        } else {
            if (modalWidget != null) {
                Widget touchedWidget = modalWidget.getTouched(screenX, getHeight() - screenY);
                if (touchedWidget != null) {
                    touchedWidget.onTouched();
                    return true;
                }
            }

            for (Widget widget : getChildWidgets()) {
                Widget touchedWidget = widget.getTouched(screenX, getHeight() - screenY);
                if (touchedWidget != null) {
                    touchedWidget.onTouched();
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void showModal(Widget widget) {
        hideModal(modalWidget);
        if (widget != null) {
            modalWidget = widget;
            widget.setVisible(true);
        }
    }

    public void hideModal(Widget widget) {
        if (widget != null) {
            modalWidget = null;
            widget.setVisible(false);
        }
    }

    public void hideModal() {
        if (modalWidget != null) {
            modalWidget.setVisible(false);
            modalWidget = null;
        }
    }

    @Override
    protected float getDefaultWidth() {
        return WIDTH;
    }

    @Override
    protected float getDefaultHeight() {
        return HEIGHT;
    }

    @Override
    protected String getDefaultTextureName() {
        return null;
    }

    private void initRenderer() {
        renderer = new Renderer(new SpriteBatch());
        renderer.addRenderable(this);
    }

    private void initSelf() {
        setVisible(true);
        setTouchable(true);
    }
}
