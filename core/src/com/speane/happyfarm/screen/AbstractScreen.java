package com.speane.happyfarm.screen;

import com.badlogic.gdx.ScreenAdapter;

public abstract class AbstractScreen<V extends AbstractView, G extends AbstractGame> extends ScreenAdapter {

    private V view;
    private G game;

    @Override
    public void render(float delta) {
        super.render(delta);

        updateGame(delta);
        renderView();
    }

    public void updateGame(float delta) {
        if (game != null) {
            game.update(delta);
        }
    }

    public void renderView() {
        if (view != null) {
            view.render();
        }
    }

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }

    public G getGame() {
        return game;
    }

    public void setGame(G game) {
        this.game = game;
    }
}
