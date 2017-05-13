package com.speane.happyfarm;

import com.speane.happyfarm.entity.*;
import com.speane.happyfarm.screen.AbstractGame;
import com.speane.happyfarm.screen.MainScreen;
import com.speane.happyfarm.screen.entityshop.EntityShopScreen;
import com.speane.happyfarm.screen.start.StartScreen;
import com.speane.happyfarm.table.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HappyFarmGame extends AbstractGame {

	private Grid grid;
	private Score score;
	private StartScreen startScreen;
	private MainScreen mainScreen;
	private EntityShopScreen entityShopScreen;

	private List<EntityType> availableEntityTypes;
	private List<StockEntity> stockEntities;

	@Override
	public void create () {
		initAvailableEntityTypes();
		initStockEntities();
		initScore();
		initGrid();
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
		for (Cell[] row : grid.getCells()) {
			for (Cell cell : row) {
				if (cell.getContainer() != null && cell.getContainer().getEntity() != null) {
					cell.getContainer().getEntity().update(delta);
				}
			}
		}
	}

	public List<EntityType> getAvailableEntityTypes() {
		List<EntityType> types = new ArrayList<EntityType>();
		EntityType type = new EntityType();
		type.setSatietyVelocity(0.5f);
		type.setHealthVelocity(0.5f);
		type.setReadinessVelocity(0.5f);
		int random = new Random().nextInt(100);
		if (random % 2 == 0) {
			type.setPrice(100);
			type.setTextureName("test1");
		} else {
			type.setPrice(200);
			type.setTextureName("test2");
		}

		types.add(type);

		type = new EntityType();
		type.setSatietyVelocity(0.5f);
		type.setHealthVelocity(0.5f);
		type.setReadinessVelocity(0.5f);
		random = new Random().nextInt(100);
		if (random % 2 == 0) {
			type.setPrice(100);
			type.setTextureName("test1");
		} else {
			type.setPrice(200);
			type.setTextureName("test2");
		}

		types.add(type);

		type = new EntityType();
		type.setSatietyVelocity(0.5f);
		type.setHealthVelocity(0.5f);
		type.setReadinessVelocity(0.5f);
		random = new Random().nextInt(100);
		if (random % 2 == 0) {
			type.setPrice(100);
			type.setTextureName("test1");
		} else {
			type.setPrice(200);
			type.setTextureName("test2");
		}

		types.add(type);

		type = new EntityType();
		type.setSatietyVelocity(0.5f);
		type.setHealthVelocity(0.5f);
		type.setReadinessVelocity(0.5f);
		random = new Random().nextInt(100);
		if (random % 2 == 0) {
			type.setPrice(100);
			type.setTextureName("test1");
		} else {
			type.setPrice(200);
			type.setTextureName("test2");
		}

		types.add(type);

		type = new EntityType();
		type.setSatietyVelocity(0.5f);
		type.setHealthVelocity(0.5f);
		type.setReadinessVelocity(0.5f);
		random = new Random().nextInt(100);
		if (random % 2 == 0) {
			type.setPrice(100);
			type.setTextureName("test1");
		} else {
			type.setPrice(200);
			type.setTextureName("test2");
		}

		types.add(type);

		type = new EntityType();
		type.setSatietyVelocity(0.5f);
		type.setHealthVelocity(0.5f);
		type.setReadinessVelocity(0.5f);
		random = new Random().nextInt(100);
		if (random % 2 == 0) {
			type.setPrice(100);
			type.setTextureName("test1");
		} else {
			type.setPrice(200);
			type.setTextureName("test2");
		}

		types.add(type);
		type = new EntityType();
		type.setSatietyVelocity(0.5f);
		type.setHealthVelocity(0.5f);
		type.setReadinessVelocity(0.5f);
		random = new Random().nextInt(100);
		if (random % 2 == 0) {
			type.setPrice(100);
			type.setTextureName("test1");
		} else {
			type.setPrice(200);
			type.setTextureName("test2");
		}

		types.add(type);


		return types;
	}

	public void setAvailableEntityTypes(List<EntityType> availableEntityTypes) {
		this.availableEntityTypes = availableEntityTypes;
	}

	public void save() {

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
		if (score.getValue() >= 35) {
			Entity entity = cell.getContainer().getEntity();
			entity.setHealth(Math.min(1, entity.getHealth() + 0.5f));
			score.setValue(score.getValue() - 35);
		}
	}

	public void feedCell(Cell cell) {
		if (score.getValue() >= 5) {
			Entity entity = cell.getContainer().getEntity();
			entity.setSatiety(Math.min(1, entity.getSatiety() + 0.5f));
			score.setValue(score.getValue() - 5);
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
				System.out.println(stockEntity.getAmount());
				stockEntity.setAmount(stockEntity.getAmount() + 1);
				stockUpdated();
				return;
			}
		}

		StockEntity stockEntity = new StockEntity();
		stockEntity.setAmount(1);
		stockEntity.setType(type);
		stockUpdated();
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

	private void initScore() {
		score = new Score();
		score.setValue(2000);
	}

	private void initScreens() {
		startScreen = new StartScreen(this);
		mainScreen = new MainScreen(this);
		entityShopScreen = new EntityShopScreen(this);
	}

	private void initAvailableEntityTypes() {
		availableEntityTypes = new ArrayList<EntityType>();
		EntityType type = new EntityType();
		type.setTextureName("first_entity");
		type.setPrice(156);
		availableEntityTypes.add(type);
		type = new EntityType();
		type.setTextureName("second_entity");
		type.setPrice(452);
		availableEntityTypes.add(type);
	}

	private void initStockEntities() {
		stockEntities = new ArrayList<StockEntity>();
		StockEntity entity = new StockEntity();
		EntityType type = new EntityType();
		type.setPrice(13);
		type.setReadinessVelocity(0.5f);
		type.setHealthVelocity(-0.05f);
		type.setSatietyVelocity(-0.04f);
		type.setTextureName("test1");
		entity.setType(type);
		entity.setAmount(23);
		stockEntities.add(entity);

		entity = new StockEntity();
		type = new EntityType();
		type.setPrice(133);
		type.setReadinessVelocity(0.2f);
		type.setHealthVelocity(-0.05f);
		type.setSatietyVelocity(-0.04f);
		type.setTextureName("test2");
		entity.setType(type);
		entity.setAmount(23);
		stockEntities.add(entity);

		entity = new StockEntity();
		type = new EntityType();
		type.setPrice(133);
		type.setReadinessVelocity(0.2f);
		type.setHealthVelocity(-0.05f);
		type.setSatietyVelocity(-0.04f);
		type.setTextureName("test3");
		entity.setType(type);
		entity.setAmount(23);
		stockEntities.add(entity);
	}

	private StockEntity getStockEntity(EntityType type) {
		for (StockEntity entity : stockEntities) {
			if (entity.getType().equals(type)) {
				return entity;
			}
		}

		return null;
	}
}
