package com.speane.happyfarm.entity;

import com.speane.happyfarm.table.*;

import java.util.HashMap;
import java.util.Map;

public class TextureNameRepository {

    private Map<Class<? extends Widget>, String> textureNameMappings;

    public TextureNameRepository() {
        initTextureNameMappings();
    }

    public String getTextureName(Widget widget) {
        if (textureNameMappings.containsKey(widget.getClass())) {
            return textureNameMappings.get(widget.getClass());
        }

        return null;
    }

    private void initTextureNameMappings() {
        textureNameMappings = new HashMap<Class<? extends Widget>, String>();
        textureNameMappings.put(UiGrid.class, "table");
        textureNameMappings.put(UiCell.class, "cell");
        textureNameMappings.put(UiEntityContainer.class, "container");
        textureNameMappings.put(UiEntity.class, "entity.class");
    }
}
