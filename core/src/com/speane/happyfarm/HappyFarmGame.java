package com.speane.happyfarm;

import com.badlogic.gdx.Game;
import com.speane.happyfarm.entity.Container;
import com.speane.happyfarm.screen.MainScreen;

public class HappyFarmGame extends Game {
	
	@Override
	public void create () {
		setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		System.out.println("RENDER");
		super.render();
	}

	public Container[][] getContainers() {
		return new Container[3][2];
	}
}
