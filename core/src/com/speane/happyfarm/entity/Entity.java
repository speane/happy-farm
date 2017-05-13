package com.speane.happyfarm.entity;

public class Entity {

    private EntityType type;
    private float readiness;
    private float health;
    private float satiety;

    public Entity(EntityType type) {
        this.type = type;
    }

    public void update(float time) {
        updateHealth(time);
        updateReadiness(time);
        updateSatiety(time);
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public float getReadiness() {
        return readiness;
    }

    public void setReadiness(float readiness) {
        this.readiness = readiness;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getSatiety() {
        return satiety;
    }

    public void setSatiety(float satiety) {
        this.satiety = satiety;
    }

    public boolean isReady() {
        return readiness >= 1;
    }

    private void updateReadiness(float time) {
        readiness += Math.min(1, time * getType().getReadinessVelocity());
    }

    private void updateHealth(float time) {
        health = Math.max(0, health + time * getType().getHealthVelocity());
    }

    private void updateSatiety(float time) {
        satiety = Math.max(0, satiety + time * getType().getSatietyVelocity());
    }
}
