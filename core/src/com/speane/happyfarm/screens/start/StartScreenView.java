package com.speane.happyfarm.screens.start;

import com.speane.happyfarm.ui.handler.TouchHandler;
import com.speane.happyfarm.ui.UiButton;

public interface StartScreenView {

    void setStartButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setLoadButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler);
}
