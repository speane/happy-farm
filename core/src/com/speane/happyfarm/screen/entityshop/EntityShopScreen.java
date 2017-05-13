package com.speane.happyfarm.screen.entityshop;

import com.speane.happyfarm.HappyFarmGame;
import com.speane.happyfarm.screen.AbstractScreen;
import com.speane.happyfarm.table.TouchHandler;
import com.speane.happyfarm.table.UiButton;

public class EntityShopScreen extends AbstractScreen<UiEntityShopView, HappyFarmGame> {

    public EntityShopScreen(HappyFarmGame game) {
        initGame(game);
        initView();
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
