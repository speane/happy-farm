package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Cell;
import com.speane.happyfarm.entity.Grid;

public interface GameStateOwner {

    Grid getGrid();
    Score getScore();
    void createEntityAtCell(Cell cell);
    void removeEntityAtCell(Cell cell);
    void addGameStateListener(GameStateListener listener);
}
