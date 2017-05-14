package com.speane.happyfarm.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.render.TextureRepository;
import com.speane.happyfarm.render.Renderable;
import com.speane.happyfarm.render.Renderer;
import com.speane.happyfarm.ui.handler.TouchHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class Widget implements Renderable {

    private List<Widget> childWidgets;
    private float x;
    private float y;
    private float width;
    private float height;
    private TextureRegion texture;
    private boolean touchable;
    private boolean visible;
    private Widget parent;
    private TouchHandler touchHandler;

    public Widget() {
        childWidgets = new ArrayList<Widget>();
        setSize(getDefaultWidth(), getDefaultHeight());
        setTexture(getDefaultTextureName());
        init();
    }

    public List<Widget> getChildWidgets() {
        return childWidgets;
    }

    public void setChildWidgets(List<Widget> childWidgets) {
        this.childWidgets = childWidgets;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        for (Widget child : childWidgets) {
            child.setX(child.getX() + (x - this.x));
        }

        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        for (Widget child : childWidgets) {
            child.setY(child.getY() + (y - this.y));
        }

        this.y = y;
    }

    public void setSize(float width, float height) {
        for (Widget child : childWidgets) {
            child.setPosition(
                    child.getX() / this.width * width,
                    child.getY() / this.height * height);
            child.setSize(
                    child.getWidth() / this.width * width,
                    child.getHeight() / this.height * height);
        }

        setWidth(width);
        setHeight(height);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if (this.getClass().equals(UiProgressBarInner.class)) {

        }
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    public void setTexture(String name) {
        texture = TextureRepository.getTextureByName(name);
    }

    public boolean isTouchable() {
        return touchable && (parent == null || parent.isTouchable());
    }

    public void setTouchable(boolean touchable) {
        this.touchable = touchable;
    }

    public boolean isVisible() {
        return visible && (parent == null || parent.isVisible());
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Widget getParent() {
        return parent;
    }

    public void setParent(Widget parent) {
        this.parent = parent;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.render(this);
        for (Widget widget : getChildWidgets()) {
            widget.render(renderer);
        }
    }

    public void appendChild(Widget child, float relativeX, float relativeY) {
        child.setX(x + relativeX);
        child.setY(y + relativeY);
        child.setParent(this);
        childWidgets.add(child);
    }

    public void removeChild(Widget widget) {
        childWidgets.remove(widget);
    }

    protected void removeAllChildren() {
        childWidgets.clear();
    }

    public void onTouched() {
        if (touchHandler != null) {
            touchHandler.onTouch(this);
        }
    }

    public void setTouchHandler(TouchHandler touchHandler) {
        this.touchHandler = touchHandler;
    }

    public Widget getTouched(double x, double y) {
        for (Widget child : childWidgets) {
            Widget widget = child.getTouched(x, y);
            if (widget != null) {
                return widget;
            }
        }

        if (isTouchable() && isTouched(x, y)) {
            return this;
        } else {
            return null;
        }
    }

    public boolean isTouched(double x, double y) {
        return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
    }

    protected void init() {
    }

    protected abstract float getDefaultWidth();

    protected abstract float getDefaultHeight();

    protected abstract String getDefaultTextureName();
}
