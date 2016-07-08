package com.project.phamhoang.weatherapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by phamhoang on 7/8/16.
 */
public class DetailActivity extends AppCompatActivity{
    private int layoutID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        int province = (int) bundle.get("province");
        switch (province) {
            case 1:
                layoutID = R.layout.activity_hp;
                break;
            case 2:
                layoutID = R.layout.activity_nd;
                break;
            case 3:
                layoutID = R.layout.activity_hn;
                break;
            default:break;
        }
        setContentView(layoutID);

    }
}
