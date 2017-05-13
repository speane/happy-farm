package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.entity.EntityType;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.entity.StockEntity;

import java.util.List;

public interface GameStateOwner {

    Grid getGrid();
    Score getScore();
    List<StockEntity> getStockEntities();
    void createEntityAtCell(Cell cell, EntityType type);
    void takeResultFromCell(Cell cell);
    void addGameStateListener(GameStateListener listener);
}
