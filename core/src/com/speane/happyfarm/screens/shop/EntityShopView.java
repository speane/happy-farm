package com.speane.happyfarm.screens.shop;

import com.speane.happyfarm.ui.handler.TouchHandler;
import com.speane.happyfarm.ui.UiButton;

public interface EntityShopView {

    void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setEntityTypeTouchHandler(TouchHandler<UiEntityType> touchHandler);
}
