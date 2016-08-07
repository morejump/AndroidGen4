package com.project.phamhoang.webservicedemo;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.jar.Manifest;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "201b3849bd1975ca152b20fb7f3d1346";
    private static final String API = "http://api.openweathermap.org/data/2.5/weather";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (Build.VERSION.SDK_INT >=23) {
//            ActivityCompat.requestPermissions(MainActivity.this, new String[] {android.Manifest.permission.INTERNET},);
//        }
        DownloadJson downloadJson = new DownloadJson();
        downloadJson.execute(API+"?q=Hanoi&&APPID="+API_KEY);

    }

    public class DownloadJson extends AsyncTask<String, Void, String>  {

        @Override
        protected String doInBackground(String... params) {
            InputStream inputStream;
            HttpsURLConnection httpsURLConnection;
            String result = "";
            try {
                URL url = new URL(params[0]);
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                if (httpsURLConnection.getResponseCode() == httpsURLConnection.HTTP_OK) {
                    inputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();
                    String inputString;
                    while ((inputString = bufferedReader.readLine()) != null) {
                        stringBuilder.append(inputString);
                    }

                    result = stringBuilder.toString();
                    httpsURLConnection.disconnect();
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
            return result;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                JsonModel jsonModel = (new Gson()).fromJson(s, JsonModel.class);
                Log.d("Main : ", jsonModel.getJsonWeatherModel().get(0).getMain());
                Log.d("Description : ", jsonModel.getJsonWeatherModel().get(0).getDescription());
                Log.d("Temp : ", jsonModel.getJsonMainModel().getTemp()+"");
            }
        }

    }
}
