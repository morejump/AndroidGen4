package com.project.phamhoang.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView listRecyclerView;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    private List<GetItemData> getItemDataList = new ArrayList<>();
    private Button btnBack;
    private MyAdapter myAdapter;
    final int[] mfp_photo = {R.drawable.dg, R.drawable.er, R.drawable.ib,
            R.drawable.m, R.drawable.md, R.drawable.mk, R.drawable.r, R.drawable.rf,
            R.drawable.rn, R.drawable.sm};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        listRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listRecyclerView.setHasFixedSize(true);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        listRecyclerView.setLayoutManager(gaggeredGridLayoutManager);
        Bundle bundle = getIntent().getExtras();
        GetItemData getItemData = new GetItemData(bundle.getString("Name"), bundle.getString("Age"), bundle.getString("Date of Birth"),
                bundle.getString("Address"), bundle.getString("Gender"), bundle.getInt("list_length"));
        myAdapter = new MyAdapter(getItemDataList, this);
        myAdapter.addItem(getItemData);
//        myAdapter.notifyDataSetChanged();
        listRecyclerView.setAdapter(myAdapter);
        btnBack = (Button) findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonBack:
                Intent intent = new Intent(this, new MainActivity().getClass());
                startActivity(intent);
                break;
            default:break;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView fp_photo;
        public TextView fp_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            fp_name = (TextView) itemView.findViewById(R.id.fp_name);
            fp_photo = (ImageView) itemView.findViewById(R.id.fp_photo);

        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        Context context;
        private List<GetItemData> getItemDataList_Adapter;

        public MyAdapter(List<GetItemData> getItemDataList_Adapter, Context context) {
            super();
            this.context = context;
            this.getItemDataList_Adapter = getItemDataList_Adapter;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (parent.getTag() != null) {
                return (MyViewHolder)(parent.getTag());
            } else {
                View view = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);
                MyViewHolder viewHolder = new MyViewHolder(view);
                return viewHolder;
            }
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder,int position) {
            Random rand = new Random();
            int _rpositon = rand.nextInt(mfp_photo.length);


            holder.fp_photo.setImageResource(mfp_photo[position]);
            holder.fp_name.setText(getItemDataList_Adapter.get(position).getName());

        }

        @Override
        public int getItemCount() {
            return getItemDataList_Adapter.size();
        }
        public void addItem(GetItemData Data) {
            getItemDataList_Adapter.add(Data);
            notifyDataSetChanged();
//            notifyItemInserted(position);
        }

    }
}
