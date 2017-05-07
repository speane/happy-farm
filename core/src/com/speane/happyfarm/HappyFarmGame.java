package com.speane.happyfarm;

import com.badlogic.gdx.Game;
import com.speane.happyfarm.screen.MainScreen;

public class HappyFarmGame extends Game {
	
	@Override
	public void create () {
		setScreen(new MainScreen());
	}

	@Override
	public void render () {
		System.out.println("RENDER");
		super.render();
	}
}
