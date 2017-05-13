package com.speane.happyfarm.entity;

public class StockEntity {

    private EntityType type;
    private int amount;

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
