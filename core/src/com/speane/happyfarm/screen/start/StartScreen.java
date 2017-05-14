package com.speane.happyfarm.screen.start;

import com.speane.happyfarm.HappyFarmGame;
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
        initStartButtonHandler();
        initLoadButtonHandler();
        initExitButtonHandler();
    }

    private void initStartButtonHandler() {
        getView().setStartButtonTouchHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().startNewGame();
            }
        });
    }

    private void initLoadButtonHandler() {
        getView().setLoadButtonTouchHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().loadGame();
                getGame().showMainScreen();
            }
        });
    }

    private void initExitButtonHandler() {
        getView().setExitButtonTouchHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().exit();
            }
        });
    }
}
