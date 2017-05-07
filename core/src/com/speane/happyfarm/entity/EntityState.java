package com.speane.happyfarm.entity;

public class EntityState {

    private int age;
    private int health;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityState state = (EntityState) o;

        if (age != state.age) return false;
        return health == state.health;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + health;
        return result;
    }
}
