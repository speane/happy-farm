package com.speane.happyfarm.table;

public abstract class ValueObserver<V, S> {

    private S source;

    public ValueObserver(S source) {
        this.source = source;
    }

    public abstract V getValue();

    public S getSource() {
        return source;
    }

    public void setSource(S source) {
        this.source = source;
    }
}
