package com.project.phamhoang.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listViewContact;
    private List<String> listContactName;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init View

        listViewContact = (ListView) findViewById(R.id.list_contact);

        // init Data

        listContactName = new ArrayList<>();
        listContactName.add("Hung");
        listContactName.add("Duc");
        listContactName.add("Hoang");
        listContactName.add("Quyen");
        listContactName.add("Du");
        listContactName.add("Luu");
        listContactName.add("Hiep");
        listContactName.add("Tung");
        listContactName.add("Dzung");

        //init Adapter
        myAdapter = new MyAdapter(listContactName, this);
        listViewContact.setAdapter(myAdapter);
        listViewContact.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, listContactName.get(i), Toast.LENGTH_SHORT).show();
    }
}
