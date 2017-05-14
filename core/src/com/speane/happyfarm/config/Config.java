package com.speane.happyfarm.config;

public class Config {

    private float screenWidth;
    private float screenHeight;
    private float entityHealthVelocityIncrement;
    private String textureAtlasName;
    private int feedCost;
    private int healCost;
    private float feedValue;
    private float healValue;
    private int mainGridRowCount;
    private int mainGridColumnCount;
    private int initialScore;
    private String backgroundColorCode;
    private String backgroundMusicFilename;

    public static Config INSTANCE;

    public int getFeedCost() {
        return feedCost;
    }

    public void setFeedCost(int feedCost) {
        this.feedCost = feedCost;
    }

    public int getHealCost() {
        return healCost;
    }

    public void setHealCost(int healCost) {
        this.healCost = healCost;
    }

    public String getTextureAtlasName() {

        return textureAtlasName;
    }

    public void setTextureAtlasName(String textureAtlasName) {
        this.textureAtlasName = textureAtlasName;
    }

    public float getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(float screenWidth) {
        this.screenWidth = screenWidth;
    }

    public float getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(float screenHeight) {
        this.screenHeight = screenHeight;
    }

    public float getEntityHealthVelocityIncrement() {
        return entityHealthVelocityIncrement;
    }

    public void setEntityHealthVelocityIncrement(float entityHealthVelocityIncrement) {
        this.entityHealthVelocityIncrement = entityHealthVelocityIncrement;
    }

    public float getFeedValue() {
        return feedValue;
    }

    public void setFeedValue(float feedValue) {
        this.feedValue = feedValue;
    }

    public float getHealValue() {
        return healValue;
    }

    public void setHealValue(float healValue) {
        this.healValue = healValue;
    }

    public int getMainGridRowCount() {
        return mainGridRowCount;
    }

    public void setMainGridRowCount(int mainGridRowCount) {
        this.mainGridRowCount = mainGridRowCount;
    }

    public int getMainGridColumnCount() {
        return mainGridColumnCount;
    }

    public void setMainGridColumnCount(int mainGridColumnCount) {
        this.mainGridColumnCount = mainGridColumnCount;
    }

    public int getInitialScore() {
        return initialScore;
    }

    public void setInitialScore(int initialScore) {
        this.initialScore = initialScore;
    }

    public String getBackgroundColorCode() {
        return backgroundColorCode;
    }

    public void setBackgroundColorCode(String backgroundColorCode) {
        this.backgroundColorCode = backgroundColorCode;
    }

    public String getBackgroundMusicFilename() {
        return backgroundMusicFilename;
    }

    public void setBackgroundMusicFilename(String backgroundMusicFilename) {
        this.backgroundMusicFilename = backgroundMusicFilename;
    }
}
