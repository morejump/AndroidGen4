package com.project.phamhoang.tripadvisor1;

/**
 * Created by phamhoang on 7/23/16.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by tqdu on 7/23/2016.
 */
public class MainPageFragment extends Fragment {

    Context context;
    ImageView background;
    Button btnShowNearBy;
    Button btnMark;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.welcome_screen,null);
        btnShowNearBy = (Button) view.findViewById(R.id.btn_show_nearby);
        btnMark = (Button) view.findViewById(R.id.btn_mark_favorite);
        //btnShowNearBy.set
        //btnShowNearBy.setImageResource(R.drawable.icon_home_nav_near_me_now);
        //btnMark.setImageResource(R.drawable.icon_home_nav_saves);
        return  view;
    }
}