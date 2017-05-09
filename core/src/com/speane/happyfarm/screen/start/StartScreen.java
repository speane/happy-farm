package com.speane.happyfarm.screen.start;

import com.speane.happyfarm.HappyFarmGame;
import com.speane.happyfarm.entity.Grid;
import com.speane.happyfarm.screen.AbstractScreen;
import com.speane.happyfarm.table.TouchHandler;
import com.speane.happyfarm.table.UiButton;

public class StartScreen extends AbstractScreen<StartScreenView, HappyFarmGame> {

    public StartScreen(HappyFarmGame game) {
        setGame(game);
        initView();
    }

    private void initView() {
        setView(new StartScreenView());
        initHandlers();
    }

    private void initHandlers() {
        getView().setStartButtonTouchHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().showMainScreen();
            }
        });
    }

    @Override
    public void gridChanged(Grid grid) {

    }
}
