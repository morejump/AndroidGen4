package com.project.phamhoang.weatherapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
    }

    private void connectView() {
        imgV = (ImageView) findViewById(R.id.imageStart);
        loadImageView(imgV);
    }

    private void loadImageView(ImageView mImageView) {
        mImageView.setImageResource(R.drawable.cloudy_day_xxx);
    }


}
