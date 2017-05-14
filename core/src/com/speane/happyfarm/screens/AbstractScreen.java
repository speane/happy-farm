package com.speane.happyfarm.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.entity.StockEntity;
import com.speane.happyfarm.game.AbstractGame;
import com.speane.happyfarm.game.GameStateListener;
import com.speane.happyfarm.game.Score;

import java.util.List;

public abstract class AbstractScreen<V extends AbstractView, G extends AbstractGame> extends ScreenAdapter
        implements GameStateListener {

    private V view;
    private G game;

    @Override
    public void show() {
        Gdx.input.setInputProcessor(view);
        view.hideModal();
    }

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

    protected void subscribeOnGameState() {
        getGame().addGameStateListener(this);
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
        subscribeOnGameState();
    }

    @Override
    public void gridChanged(Grid grid) {
    }

    @Override
    public void scoreChanged(Score score) {
    }

    @Override
    public void stockChanged(List<StockEntity> stock) {
    }
}
