package com.speane.happyfarm.entity;

import java.util.HashMap;
import java.util.Map;

public class PlantStateSource implements EntityStateSource<Plant> {

    private Map<Integer, Integer> stateThresholds;

    public PlantStateSource() {
        stateThresholds = new HashMap<Integer, Integer>();
        stateThresholds.put(30, 3);
        stateThresholds.put(20, 2);
        stateThresholds.put(10, 1);
        stateThresholds.put(0, 0);
    }

    @Override
    public EntityState getState(Plant plant) {
        final EntityState state = new EntityState();
        state.setAge(0);
        state.setHealth(0);

        return state;
    }
}
