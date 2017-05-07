package com.speane.happyfarm.entity;

public abstract class AbstractEntityStateSourceFactory<T extends EntityStateSource> {

    public abstract T createInstance();
}
