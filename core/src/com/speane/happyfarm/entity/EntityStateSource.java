package com.speane.happyfarm.entity;

public interface EntityStateSource<T extends Entity> {

    EntityState getState(T entity);
}
