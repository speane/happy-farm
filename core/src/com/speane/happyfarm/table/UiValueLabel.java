package com.speane.happyfarm.table;

public class UiValueLabel extends UiLabel {

    private ValueObserver valueObserver;

    public void setValueObserver(ValueObserver valueObserver) {
        this.valueObserver = valueObserver;
    }

    @Override
    public String getText() {
        return valueObserver != null ? valueObserver.getValue().toString() : "";
    }
}
