package com.speane.happyfarm.screen;

import com.badlogic.gdx.Game;

public abstract class AbstractGame extends Game {

    @Override
    public void render() {
        super.render();
    }

    public abstract void update(float delta);
}
