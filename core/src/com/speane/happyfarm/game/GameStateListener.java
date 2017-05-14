package com.speane.happyfarm.game;

import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.entity.StockEntity;

import java.util.List;

public interface GameStateListener {

    void gridChanged(Grid grid);
    void scoreChanged(Score score);
    void stockChanged(List<StockEntity> stock);
}
