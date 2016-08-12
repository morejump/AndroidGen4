package com.project.phamhoang.weatherappnghean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phamhoang on 8/13/16.
 */
public class JsonWeatherModel {

    private static final String ID = "id";
    private static final String MAIN = "main";
    private static final String DESCRIPTION = "description";
    private static final String ICON = "icon";

    @SerializedName(ID)
    private String id;
    @SerializedName(DESCRIPTION)
    private String description;
    @SerializedName(MAIN)
    private String main;
    @SerializedName(ICON)
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
