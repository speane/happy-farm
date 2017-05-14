package com.speane.happyfarm.table;

import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.entity.StockEntity;

import java.util.List;

public class State {

    private Grid grid;
    private Score score;
    private List<StockEntity> stock;

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public List<StockEntity> getStock() {
        return stock;
    }

    public void setStock(List<StockEntity> stock) {
        this.stock = stock;
    }
}
