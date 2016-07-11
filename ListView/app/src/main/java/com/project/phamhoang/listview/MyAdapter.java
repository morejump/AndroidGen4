package com.project.phamhoang.listview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by phamhoang on 7/10/16.
 */
public class MyAdapter extends BaseAdapter{

    private List<String> listContact;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<String> listContact, Context context) {
        this.listContact = listContact;
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int i) {
        return listContact.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.item_on_list, null);
        if (view != null) {
            TextView txtContactName = (TextView) view.findViewById(R.id.txt_name);
            Button btnShow = (Button) view.findViewById(R.id.btnShow);
            txtContactName.setText(listContact.get(i));
            txtContactName.setTextColor(view.getResources().getColor(R.color.colorPrimary));
            btnShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), listContact.get(i), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return view;
    }
}
