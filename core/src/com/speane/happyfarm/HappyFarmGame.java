package com.speane.happyfarm;

import com.speane.happyfarm.entity.Container;
import com.speane.happyfarm.entity.Entity;
import com.speane.happyfarm.screen.AbstractGame;
import com.speane.happyfarm.screen.start.StartScreen;

public class HappyFarmGame extends AbstractGame {

	private Container[][] containers;
	
	@Override
	public void create () {
		initContainers();
		setScreen(new StartScreen(this));
	}

	public void update(float delta) {
		updateContainers(delta);
	}

	public Container[][] getContainers() {
		return containers;
	}

	private void updateContainers(float delta) {
		for (int i = 0; i < containers.length; i++) {
			for (int j = 0; j < containers[0].length; j++) {
				if (containers[i][j].getEntity() != null) {
					containers[i][j].getEntity().update(delta * 10);
				}
			}
		}
	}

	private void initContainers() {
		int width = 3;
		int height = 4;
		containers = new Container[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Container container = new Container();
				containers[i][j] = container;
				if ((i + j) % 2 == 0) {
					container.setEntity(new Entity());
				}
			}
		}
	}
}
