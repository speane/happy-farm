package com.speane.happyfarm.screen;

import com.badlogic.gdx.Game;
import com.speane.happyfarm.table.GameStateListener;
import com.speane.happyfarm.table.GameStateOwner;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame extends Game implements GameStateOwner {

    private List<GameStateListener> gameStateListeners;

    public AbstractGame() {
        initGameStateListeners();
    }

    @Override
    public void render() {
        super.render();
    }

    public void gridUpdated() {
        for (GameStateListener gameStateListener : gameStateListeners) {
            gameStateListener.gridChanged(getGrid());
        }
    }

    public void scoreUpdated() {
        for (GameStateListener gameStateListener : gameStateListeners) {
            gameStateListener.scoreChanged(getScore());
        }
    }

    public void stockUpdated() {
        for (GameStateListener gameStateListener : gameStateListeners) {
            gameStateListener.stockChanged(getStockEntities());
        }
    }

    @Override
    public void addGameStateListener(GameStateListener listener) {
        gameStateListeners.add(listener);
    }

    public abstract void update(float delta);

    private void initGameStateListeners() {
        gameStateListeners = new ArrayList<GameStateListener>();
    }
}
