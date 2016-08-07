package com.project.phamhoang.webservicedemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phamhoang on 8/6/16.
 */
public class JsonMainModel {
    private static final String TEMP = "temp";
    private static final String PRESSURE = "pressure";
    private static final String HUMIDITY ="humidity";
    @SerializedName(TEMP)
    private Double temp;
    @SerializedName(PRESSURE)
    private Double pressure;
    @SerializedName(HUMIDITY)
    private int humidity;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
