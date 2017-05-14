package com.speane.happyfarm.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.speane.happyfarm.game.HappyFarmGame;

public class DesktopLauncher {

	private static final int SCREEN_WIDTH = 640;
	private static final int SCREEN_HEIGHT = 640;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SCREEN_WIDTH;
		config.height = SCREEN_HEIGHT;
		new LwjglApplication(new HappyFarmGame(), config);
	}
}
