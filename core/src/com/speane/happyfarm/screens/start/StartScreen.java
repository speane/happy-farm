package com.speane.happyfarm.screens.start;

import com.speane.happyfarm.screens.AbstractScreen;
import com.speane.happyfarm.game.HappyFarmGame;
import com.speane.happyfarm.ui.handler.TouchHandler;
import com.speane.happyfarm.ui.UiButton;

public class StartScreen extends AbstractScreen<UiStartScreenView, HappyFarmGame> {

    public StartScreen(HappyFarmGame game) {
        setGame(game);
        initView();
    }

    private void initView() {
        setView(new UiStartScreenView());
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
