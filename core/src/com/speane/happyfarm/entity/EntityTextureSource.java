package com.speane.happyfarm.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.speane.happyfarm.table.UiEntity;

import java.util.HashMap;
import java.util.Map;

public class EntityTextureSource implements TextureSource<UiEntity> {

    private Map<EntityState, String> textureMappings;
    private Map<Class<? extends Entity>, EntityStateSource> stateSources;

    public EntityTextureSource() {
        textureMappings = new HashMap<EntityState, String>();
        EntityState state = new EntityState();
        state.setAge(0);
        state.setHealth(0);
        textureMappings.put(state, "test1.png");
        state = new EntityState();
        state.setAge(1);
        state.setHealth(1);
        textureMappings.put(state, "test2.png");
        state = new EntityState();
        state.setAge(2);
        state.setHealth(2);
        textureMappings.put(state, "test3.png");
        stateSources = new HashMap<Class<? extends Entity>, EntityStateSource>();
        stateSources.put(Plant.class, new PlantStateSource());
    }

    @Override
    public TextureRegion getTexture(UiEntity widget) {
        if (stateSources.containsKey(widget.getEntity().getClass())) {
            EntityStateSource stateSource = stateSources.get(widget.getEntity().getClass());
            EntityState state = stateSource.getState(widget.getEntity());
            if (textureMappings.containsKey(state)) {
                return getTexture(textureMappings.get(state));
            }
        }

        return null;
    }

    private TextureRegion getTexture(String name) {
        final TextureRegion first = new TextureRegion(new Texture("test1.png"));
        final TextureRegion second = new TextureRegion(new Texture("test2.png"));
        final TextureRegion third = new TextureRegion(new Texture("test3.png"));
        if (name.equals("test1.png")) {
            return first;
        } else if (name.equals("test2.png")) {
            return second;
        } else {
            return third;
        }
    }
}
