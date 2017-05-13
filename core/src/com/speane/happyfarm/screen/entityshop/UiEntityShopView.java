package com.speane.happyfarm.screen.entityshop;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.speane.happyfarm.entity.EntityType;
import com.speane.happyfarm.screen.AbstractView;
import com.speane.happyfarm.table.*;

import java.util.List;

public class UiEntityShopView extends AbstractView implements EntityShopView {

    private UiButton exitButton;
    private static final float EXIT_BUTTON_WIDTH = WIDTH / 6;
    private static final float EXIT_BUTTON_HEIGHT = HEIGHT / 20;
    private static final float EXIT_BUTTON_X = 0;
    private static final float EXIT_BUTTON_Y = HEIGHT - EXIT_BUTTON_HEIGHT;
    private static final String EXIT_BUTTON_TEXTURE = "exit_button";

    private UiEntityTable uiEntityTable;
    private static final float ENTITY_TABLE_WIDTH = WIDTH;
    private static final float ENTITY_TABLE_HEIGHT = HEIGHT / 5 * 4;
    private static final float ENTITY_TABLE_X = 0;
    private static final float ENTITY_TABLE_Y = 0;

    private UiLabel scoreLabel;
    private static final float SCORE_LABEL_WIDTH = 70;
    private static final float SCORE_LABEL_X = WIDTH / 6 * 5;
    private static final float SCORE_LABEL_Y = HEIGHT / 30 * 29;

    private UiValueLabel scoreValueLabel;
    private static final float SCORE_VALUE_LABEL_X = SCORE_LABEL_X + SCORE_LABEL_WIDTH;
    private static final float SCORE_VALUE_LABEL_Y = SCORE_LABEL_Y;

    private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setEntityTypes(List<EntityType> types) {
        uiEntityTable.setTypes(types);
    }

    @Override
    protected void init() {
        initUi();
    }

    private void initUi() {
        initTable();
        initExitButton();
        initScoreLabel();
        initScoreValueLabel();
    }

    private void initTable() {
        uiEntityTable = new UiEntityTable();
        uiEntityTable.setTouchable(true);
        uiEntityTable.setVisible(true);
        uiEntityTable.setSize(ENTITY_TABLE_WIDTH, ENTITY_TABLE_HEIGHT);
        appendChild(uiEntityTable, ENTITY_TABLE_X, ENTITY_TABLE_Y);
    }

    private void initExitButton() {
        exitButton = new UiButton();
        exitButton.setVisible(true);
        exitButton.setTouchable(true);
        exitButton.setTexture(EXIT_BUTTON_TEXTURE);
        exitButton.setSize(EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        appendChild(exitButton, EXIT_BUTTON_X, EXIT_BUTTON_Y);
    }

    private void initScoreLabel() {
        scoreLabel = new UiLabel();
        BitmapFont font = new BitmapFont();
        scoreLabel.setFont(font);
        scoreLabel.setVisible(true);
        scoreLabel.setText("SCORE");
        appendChild(scoreLabel, SCORE_LABEL_X, SCORE_LABEL_Y);
    }

    private void initScoreValueLabel() {
        scoreValueLabel = new UiValueLabel();
        BitmapFont font = new BitmapFont();
        scoreValueLabel.setFont(font);
        scoreValueLabel.setVisible(true);
        scoreValueLabel.setValueObserver(new ValueObserver<Integer>() {
            @Override
            public Integer getValue() {
                return getScore() != null ? getScore().getValue() : 0;
            }
        });
        appendChild(scoreValueLabel, SCORE_VALUE_LABEL_X, SCORE_VALUE_LABEL_Y);
    }

    @Override
    public void setExitButtonTouchHandler(TouchHandler<UiButton> touchHandler) {
        exitButton.setTouchHandler(touchHandler);
    }

    @Override
    public void setEntityTypeTouchHandler(TouchHandler<UiEntityType> touchHandler) {
        uiEntityTable.setEntityTypeTouchHandler(touchHandler);
    }
}
