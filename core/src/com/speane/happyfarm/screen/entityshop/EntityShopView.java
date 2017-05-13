package com.speane.happyfarm.screen.entityshop;

import com.speane.happyfarm.table.TouchHandler;
import com.speane.happyfarm.table.UiButton;

public interface EntityShopView {

    void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setEntityTypeTouchHandler(TouchHandler<UiEntityType> touchHandler);
}
