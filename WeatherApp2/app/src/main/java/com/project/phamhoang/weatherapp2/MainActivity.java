package com.project.phamhoang.weatherapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    TextView tvHP, tvND, tvHN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
    }

    private void connectView() {
        tvHP = (TextView) findViewById(R.id.tHP);
        tvND = (TextView) findViewById(R.id.tND);
        tvHN = (TextView) findViewById(R.id.tHN);
        tvHP.setOnTouchListener(this);
        tvND.setOnTouchListener(this);
        tvHN.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.tHP:
                bundle.putInt("province",1);
                break;
            case R.id.tND:
                bundle.putInt("province",2);
                break;
            case R.id.tHN:
                bundle.putInt("province",3);
                break;
            default:break;
        }
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
        return false;
    }
}
