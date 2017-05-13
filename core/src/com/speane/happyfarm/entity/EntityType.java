package com.speane.happyfarm.entity;

public class EntityType {

    private String textureName;
    private float readinessVelocity;
    private float healthVelocity;
    private float satietyVelocity;
    private int price;

    public String getTextureName() {
        return textureName;
    }

    public void setTextureName(String textureName) {
        this.textureName = textureName;
    }

    public float getReadinessVelocity() {
        return readinessVelocity;
    }

    public void setReadinessVelocity(float readinessVelocity) {
        this.readinessVelocity = readinessVelocity;
    }

    public float getHealthVelocity() {
        return healthVelocity;
    }

    public void setHealthVelocity(float healthVelocity) {
        this.healthVelocity = healthVelocity;
    }

    public float getSatietyVelocity() {
        return satietyVelocity;
    }

    public void setSatietyVelocity(float satietyVelocity) {
        this.satietyVelocity = satietyVelocity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
