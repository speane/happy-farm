package com.speane.happyfarm.entity;

public class AppConfig {

    public static String getStringProperty(String name) {
        if (name.equals("texture_atlas_filename")) {
            return "happy_farm.atlas";
        }

        return null;
    }
}
