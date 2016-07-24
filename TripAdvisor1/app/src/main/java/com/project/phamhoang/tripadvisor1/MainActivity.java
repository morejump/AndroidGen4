package com.project.phamhoang.tripadvisor1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    TabLayout mainTab;
    TabLayout.Tab hotelTab;
    TabLayout.Tab restaurantTab;
    TabLayout.Tab airportTab;
    TabLayout.Tab parkTab;
    FrameLayout mainFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GPSTracker gpsTracker = new GPSTracker(this);
        if (!gpsTracker.canGetlocation1()) {
            gpsTracker.showSettingAlert();
        } else {
            gpsTracker.getLaititude();
            gpsTracker.getLongitude();
        }

        initialize();

    }

    private void initialize() {
        //mainFrame = (FrameLayout) findViewById(R.id.main_frame);

        //Custom view for Tabs, set wanted icon size
        View viewHotel = getLayoutInflater().inflate(R.layout.custom_tab_view,null);
        ((ImageView)viewHotel.findViewById(R.id.icon)).setImageResource(R.drawable.icon_home_hotels);
        mainTab = (TabLayout) findViewById(R.id.tab_layout);
        hotelTab = mainTab.newTab();
        hotelTab.setCustomView(viewHotel);

        restaurantTab = mainTab.newTab();
        View viewRes = getLayoutInflater().inflate(R.layout.custom_tab_view,null);
        ((ImageView)viewRes.findViewById(R.id.icon)).setImageResource(R.drawable.icon_home_restaurants);
        restaurantTab.setCustomView(viewRes);

        airportTab = mainTab.newTab();
        View viewAir = getLayoutInflater().inflate(R.layout.custom_tab_view,null);
        ((ImageView)viewAir.findViewById(R.id.icon)).setImageResource(R.drawable.icon_home_flights);
        airportTab.setCustomView(viewAir);

        parkTab = mainTab.newTab();
        View viewPark = getLayoutInflater().inflate(R.layout.custom_tab_view,null);
        ((ImageView)viewPark.findViewById(R.id.icon)).setImageResource(R.drawable.icon_home_things_to_do);
        parkTab.setCustomView(viewPark);

        mainTab.addTab(hotelTab);
        mainTab.addTab(restaurantTab);
        mainTab.addTab(airportTab);
        mainTab.addTab(parkTab);

        //change action bar color
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1B5E20")));

        //Set fragment welcome page
        MainPageFragment mainPageFragment = new MainPageFragment();
        openFragment(mainPageFragment);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.addToBackStack("fragment_main");
        fragmentTransaction.commit();
    }

}
