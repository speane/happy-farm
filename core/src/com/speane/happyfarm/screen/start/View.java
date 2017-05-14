package com.speane.happyfarm.screen.start;

import com.speane.happyfarm.table.TouchHandler;
import com.speane.happyfarm.table.UiButton;

public interface View {

    void setStartButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setLoadButtonTouchHandler(TouchHandler<UiButton> touchHandler);
    void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler);
}
