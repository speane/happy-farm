package com.speane.happyfarm.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.speane.happyfarm.render.Renderable;
import com.speane.happyfarm.render.Renderer;
import com.speane.happyfarm.table.Widget;

public abstract class AbstractView extends Widget implements InputProcessor, Renderable {

    private Renderer renderer;

    private Widget modalWidget;

    public AbstractView() {
        initRenderer();
        initInputProcessor();
    }

    public void render() {
        renderer.render();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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

    public void showModal(Widget widget) {
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

    private void initRenderer() {
        renderer = new Renderer(new SpriteBatch());
        renderer.addRenderable(this);
    }

    private void initInputProcessor() {
        Gdx.input.setInputProcessor(this);
    }
}
