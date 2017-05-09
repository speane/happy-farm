package com.speane.happyfarm;

import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.entity.Container;
import com.speane.happyfarm.entity.Entity;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.screen.AbstractGame;
import com.speane.happyfarm.screen.MainScreen;
import com.speane.happyfarm.screen.start.StartScreen;
import com.speane.happyfarm.table.Score;

public class HappyFarmGame extends AbstractGame {

	private Grid grid;
	private Score score;

	@Override
	public void create () {
		initScore();
		initGrid();
		showMainScreen();
	}

	public void showMainScreen() {
		setScreen(new MainScreen(this));
	}

	public void showStartScreen() {
		setScreen(new StartScreen(this));
	}

	@Override
	public void update(float delta) {
		for (Cell[] row : grid.getCells()) {
			for (Cell cell : row) {
				if (cell.getContainer() != null && cell.getContainer().getEntity() != null) {
					cell.getContainer().getEntity().setAge(cell.getContainer().getEntity().getAge() + delta * 10);
					if (cell.getContainer().getEntity().getAge() >= cell.getContainer().getEntity().getMaxAge()) {
						score.setValue(score.getValue() + 20);
						cell.getContainer().setEntity(null);
						gridUpdated();
					}
				}
			}
		}
	}

	public void createEntityAtCell(Cell cell) {
		Entity entity = new Entity();
		entity.setMaxAge(100);
		entity.setAge(1);
		Container container = new Container();
		container.setEntity(entity);
		cell.setContainer(container);

		gridUpdated();
	}

	@Override
	public void removeEntityAtCell(Cell cell) {
		if (cell != null && cell.getContainer() != null) {
			cell.getContainer().setEntity(null);
			gridUpdated();
		}
	}

	public Grid getGrid() {
		return grid;
	}

	@Override
	public Score getScore() {
		return score;
	}

	private void initGrid() {
		grid = new Grid();
		int rowCount = 3;
		int columnCount = 3;
		Cell[][] cells = new Cell[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				Container container = new Container();
				Cell cell = new Cell();
				cell.setContainer(container);
				cells[i][j] = cell;
			}
		}

		grid.setCells(cells);
	}

	private void initScore() {
		score = new Score();
	}
}
