package com.speane.happyfarm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.speane.happyfarm.entity.*;
import com.speane.happyfarm.screen.AbstractGame;
import com.speane.happyfarm.screen.MainScreen;
import com.speane.happyfarm.screen.entityshop.EntityShopScreen;
import com.speane.happyfarm.screen.start.StartScreen;
import com.speane.happyfarm.table.Config;
import com.speane.happyfarm.table.Score;
import com.speane.happyfarm.table.State;

import java.util.ArrayList;
import java.util.List;

public class HappyFarmGame extends AbstractGame {

	private static final String CONFIG_FILENAME = "config.json";
	private static final String TYPES_FILENAME = "types.json";
	private static final String STATE_FILENAME = "state.json";

	private Grid grid;
	private Score score;
	private StartScreen startScreen;
	private MainScreen mainScreen;
	private EntityShopScreen entityShopScreen;

	private List<EntityType> availableEntityTypes;
	private List<StockEntity> stockEntities;

	private Config config;

	@Override
	public void create () {
		loadConfig();
		loadTypes();
		initEmptyState();
		initScreens();
		showStartScreen();
	}

	public void showMainScreen() {
		setScreen(mainScreen);
	}

	public void showStartScreen() {
		setScreen(startScreen);
	}

	public void showEntityShopScreen() {
		setScreen(entityShopScreen);
	}

	@Override
	public void update(float delta) {
		if (grid != null) {
			for (Cell[] row : grid.getCells()) {
				for (Cell cell : row) {
					if (cell.getContainer() != null && cell.getContainer().getEntity() != null) {
						Entity entity = cell.getContainer().getEntity();
						updateEntity(entity, delta);
						if (!entity.isAlive()) {
							cell.getContainer().setEntity(null);
							gridUpdated();
						}
					}
				}
			}
		}
	}

	private void initEmptyState() {
		initEmptyScore();
		initEmptyGrid();
		initEmptyStock();
	}

	private void updateEntity(Entity entity, float time) {
		entity.setReadiness(Math.min(1, entity.getReadiness() + time * entity.getReadinessVelocity()
				* entity.getHealth()));
		entity.setHealth(Math.max(0, entity.getHealth() - time * entity.getHealthVelocity()
				/ entity.getSatiety()));
		entity.setSatiety(Math.max(0, entity.getSatiety() - time * entity.getSatietyVelocity()));
		entity.setHealthVelocity(entity.getHealthVelocity() * 1.0001f);
	}

	public List<EntityType> getAvailableEntityTypes() {
		return availableEntityTypes;
	}


	public void save() {
		Gdx.files.local("state.json").writeString(new Json().prettyPrint(createState()), false);
	}

	public void loadGame() {
		initFromState(new Json().fromJson(State.class, Gdx.files.local("state.json").readString()));
		stateUpdated();
		showMainScreen();
	}

	public void startNewGame() {
		initEmptyState();
		stateUpdated();
		showMainScreen();
	}

	public void stateUpdated() {
		gridUpdated();
		scoreUpdated();
		stockUpdated();
	}

	public void exit() {
		Gdx.app.exit();
	}

	private void initFromState(State state) {
		if (state != null) {
			grid = state.getGrid();
			score = state.getScore();
			stockEntities = state.getStock();
		}
	}

	private State createState() {
		State state = new State();

		state.setGrid(grid);
		state.setScore(score);
		state.setStock(stockEntities);

		return state;
	}

	@Override
	public void createEntityAtCell(Cell cell, EntityType type) {
		Entity entity = new Entity(type);
		entity.setReadiness(0);
		entity.setHealth(1);
		entity.setSatiety(1);
		Container container = new Container();
		container.setEntity(entity);
		cell.setContainer(container);

		StockEntity stockEntity = getStockEntity(type);
		if (stockEntity != null) {
			stockEntity.setAmount(stockEntity.getAmount() - 1);
			if (stockEntity.getAmount() <= 0) {
				stockUpdated();
			}
		}

		gridUpdated();
	}

	@Override
	public void takeResultFromCell(Cell cell) {
		if (cell != null && cell.getContainer() != null) {
			score.setValue(score.getValue() + 20);
			cell.getContainer().getEntity().setReadiness(0);
		}
	}

	public void healCell(Cell cell) {
		if (cell.getContainer().getEntity() != null) {
			if (score.getValue() >= 35) {
				Entity entity = cell.getContainer().getEntity();
				entity.setHealth(Math.min(1, entity.getHealth() + 0.5f));
				score.setValue(score.getValue() - 35);
			}
		}
	}

	public void feedCell(Cell cell) {
		if (cell.getContainer().getEntity() != null) {
			if (score.getValue() >= 5) {
				Entity entity = cell.getContainer().getEntity();
				entity.setSatiety(Math.min(1, entity.getSatiety() + 0.5f));
				score.setValue(score.getValue() - 5);
			}
		}
	}

	public List<StockEntity> getStockEntities() {
		return stockEntities;
	}

	public void buyEntity(EntityType type) {
		if (score.getValue() >= type.getPrice()) {
			addToStock(type);
			score.setValue(score.getValue() - type.getPrice());
		}
	}

	private void addToStock(EntityType type) {
		for (StockEntity stockEntity : stockEntities) {
			if (stockEntity.getType().getTextureName().equals(type.getTextureName())) {
				stockEntity.setAmount(stockEntity.getAmount() + 1);
				stockUpdated();

				return;
			}
		}
	}

	public Grid getGrid() {
		return grid;
	}

	@Override
	public Score getScore() {
		return score;
	}

	private void initEmptyGrid() {
		grid = new Grid();
		int rowCount = 4;
		int columnCount = 4;
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

	private void initEmptyScore() {
		score = new Score();
		score.setValue(2000);
	}

	private void initScreens() {
		startScreen = new StartScreen(this);
		mainScreen = new MainScreen(this);
		entityShopScreen = new EntityShopScreen(this);
	}

	private void initEmptyStock() {
		stockEntities = new ArrayList<StockEntity>();
		for (EntityType type : availableEntityTypes) {
			StockEntity stockEntity = new StockEntity();
			stockEntity.setType(type);
			stockEntities.add(stockEntity);
		}
	}

	private StockEntity getStockEntity(EntityType type) {
		for (StockEntity entity : stockEntities) {
			if (entity.getType().equals(type)) {
				return entity;
			}
		}

		return null;
	}

	private void loadConfig() {
		config = new Json().fromJson(Config.class, Gdx.files.local(CONFIG_FILENAME).readString());
	}

	private void loadTypes() {
		availableEntityTypes = new Json().fromJson(Types.class, Gdx.files.local(TYPES_FILENAME).readString()).getTypes();
	}
}
