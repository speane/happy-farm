package com.speane.happyfarm.entity;

public class Entity {

    private static final float DEFAULT_MAX_AGE = 100;

    private float maxAge;
    private float age;

    public Entity() {
        initMaxAge();
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(float maxAge) {
        this.maxAge = maxAge;
    }

    public void update(float delta) {
        updateAge(delta);
    }

    private void updateAge(float delta) {
        this.age += delta;
    }

    private void initMaxAge() {
        maxAge = DEFAULT_MAX_AGE;
    }
}
