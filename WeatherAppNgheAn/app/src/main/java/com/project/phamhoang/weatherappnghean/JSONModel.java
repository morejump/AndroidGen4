package com.project.phamhoang.weatherappnghean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by phamhoang on 8/13/16.
 */
public class JSONModel {

    private static final String WEATHER = "weather";
    private static final String MAIN = "main";
    @SerializedName(WEATHER)
    private List<JsonWeatherModel> jsonWeatherModels;
    @SerializedName(MAIN)
    private JsonMainModel jsonMainModels;

    public List<JsonWeatherModel> getJsonWeatherModels() {
        return jsonWeatherModels;
    }

    public void setJsonWeatherModels(List<JsonWeatherModel> jsonWeatherModels) {
        this.jsonWeatherModels = jsonWeatherModels;
    }

    public JsonMainModel getJsonMainModels() {
        return jsonMainModels;
    }

    public void setJsonMainModels(JsonMainModel jsonMainModels) {
        this.jsonMainModels = jsonMainModels;
    }
}
