package com.project.phamhoang.weatherappnghean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phamhoang on 8/13/16.
 */
public class JsonMainModel  {

    private static final String TEMP = "temp";
    private static final String PRESSURE = "pressure";
    private static final String HUMIDITY = "humidity";
    private static final String TEMP_MIN = "temp_min";
    private static final String TEMP_MAX = "temp_max";

    @SerializedName(TEMP)
    private double temp;
    @SerializedName(PRESSURE)
    private double pressure;
    @SerializedName(HUMIDITY)
    private int humidity;
    @SerializedName(TEMP_MIN)
    private double temp_min;
    @SerializedName(TEMP_MAX)
    private double temp_max;

    public JsonMainModel() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
}
