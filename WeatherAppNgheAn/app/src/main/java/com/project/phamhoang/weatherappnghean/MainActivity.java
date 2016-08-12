package com.project.phamhoang.weatherappnghean;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //
    private static final String WEATHER_API_KEY = "201b3849bd1975ca152b20fb7f3d1346";
    //
    private ImageView mainImage;
    private TextView temperatureTextView;
    private TextView temperatureMaxTextView;
    private TextView temperatureMinTextView;
    private TextView humidityTextView;
    private TextView pressureTextView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
    }

    private void connectView() {
        mainImage = (ImageView) findViewById(R.id.main_image);
        temperatureTextView = (TextView) findViewById(R.id.temp);
        temperatureMaxTextView = (TextView) findViewById(R.id.temp_max);
        temperatureMinTextView = (TextView) findViewById(R.id.temp_min);
        humidityTextView = (TextView) findViewById(R.id.humidity);
        pressureTextView = (TextView) findViewById(R.id.pressure);
    }


}
