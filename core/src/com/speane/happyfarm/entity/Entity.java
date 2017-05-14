package com.speane.happyfarm.entity;

public class Entity {

    private EntityType type;
    private float readiness;
    private float health;
    private float satiety;
    private float healthVelocity;
    private float readinessVelocity;
    private float satietyVelocity;

    public Entity() {
    }

    public Entity(EntityType type) {
        this.type = type;
        this.healthVelocity = type.getHealthVelocity();
        this.readinessVelocity = type.getReadinessVelocity();
        this.satietyVelocity = type.getSatietyVelocity();
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

    public float getHealthVelocity() {
        return healthVelocity;
    }

    public void setHealthVelocity(float healthVelocity) {
        this.healthVelocity = healthVelocity;
    }

    public float getReadinessVelocity() {
        return readinessVelocity;
    }

    public void setReadinessVelocity(float readinessVelocity) {
        this.readinessVelocity = readinessVelocity;
    }

    public float getSatietyVelocity() {
        return satietyVelocity;
    }

    public void setSatietyVelocity(float satietyVelocity) {
        this.satietyVelocity = satietyVelocity;
    }

    public boolean isReady() {
        return readiness >= 1;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
