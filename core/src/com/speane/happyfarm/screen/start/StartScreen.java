package com.speane.happyfarm.screen.start;

import com.speane.happyfarm.HappyFarmGame;
import com.speane.happyfarm.screen.AbstractScreen;

public class StartScreen extends AbstractScreen<StartScreenView, HappyFarmGame> {

    private HappyFarmGame game;

    public StartScreen(HappyFarmGame game) {
        setGame(game);
        initView();
    }

    private void initView() {
        setView(new StartScreenView());
    }
}
