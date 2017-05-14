package com.speane.happyfarm.screens.shop;

import com.speane.happyfarm.game.HappyFarmGame;
import com.speane.happyfarm.screens.AbstractScreen;
import com.speane.happyfarm.game.Score;
import com.speane.happyfarm.ui.handler.TouchHandler;
import com.speane.happyfarm.ui.UiButton;

public class EntityShopScreen extends AbstractScreen<UiEntityShopView, HappyFarmGame> {

    public EntityShopScreen(HappyFarmGame game) {
        initGame(game);
        initView();
    }

    @Override
    public void scoreChanged(Score score) {
        getView().setScore(score);
    }

    private void initGame(HappyFarmGame game) {
        setGame(game);
    }

    private void initView() {
        setView(new UiEntityShopView());
        getView().setEntityTypes(getGame().getAvailableEntityTypes());
        getView().setScore(getGame().getScore());
        initViewHandlers();
    }

    private void initViewHandlers() {
        initExitButtonHandler();
        initEntityTypeSelectedHandler();
    }

    private void initExitButtonHandler() {
        getView().setExitButtonTouchHandler(new TouchHandler<UiButton>() {
            @Override
            public void onTouch(UiButton widget) {
                getGame().showMainScreen();
            }
        });
    }

    private void initEntityTypeSelectedHandler() {
        getView().setEntityTypeTouchHandler(new TouchHandler<UiEntityType>() {
            @Override
            public void onTouch(UiEntityType widget) {
                getGame().buyEntity(widget.getType());
            }
        });
    }
}
