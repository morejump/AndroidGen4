package com.project.phamhoang.alphabetspeak;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int[] mPhoto = new int[30];
    private List<ImageButton> imageButtonList;
    private RecyclerView listRecyclerview;
    private AlphabetAdapter alphabetAdapter;
    private List<Alphabet> alphabetList = new ArrayList<>();
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private ArrayList<Integer> soundList = new ArrayList<>();
    private SoundPool soundPool;
    private int i;
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        listRecyclerview = (RecyclerView) findViewById(R.id.recycler);
        listRecyclerview.setHasFixedSize(true);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        listRecyclerview.setLayoutManager(staggeredGridLayoutManager);
        alphabetAdapter = new AlphabetAdapter(alphabetList, this);

        for (int j = 0; j < 28; j++) {
            imageButton = new ImageButton(this);
            imageButton.setImageResource(getResources().getIdentifier("upper_" + j + ".png", "drawable", "com.project.phamhoang.alphabetspeak"));
            if (imageButton == null) {
                Log.d("TAG", "null photo");
            }
            else {
                Alphabet alphabet = new Alphabet(imageButton); // note
                alphabetAdapter.addItem(alphabet);
            }

        }

        listRecyclerview.setAdapter(alphabetAdapter);
        //
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        for (int i = 0; i < 28; i++) {
            soundList.add(getResources().getIdentifier("sound_" + i + ".mp3", "raw", getPackageName()));

        }
        for (i = 0; i < 28; i++) {
            if (alphabetList.get(i).getImageButton() == null) {
                Log.d("TAG", "nullpoint exception");
            }
            else {
                ImageButton imageButton = alphabetList.get(i).getImageButton();
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        soundPool.play(soundList.get(i), 1.0f, 1.0f, 1, 1, 1.0f);
                    }
                });
            }

        }
    }

    class MyViewHoder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public MyViewHoder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.portrait_view);

        }
    }
    class AlphabetAdapter extends RecyclerView.Adapter<MyViewHoder>{

        private List<Alphabet> alphabetList;

        Context context;


        public AlphabetAdapter(List<Alphabet> alphabetList, Context context ) {
            super();
            this.context = context;
            this.alphabetList = alphabetList;

        }


        @Override
        public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (parent.getTag() != null) {
                return (MyViewHoder)(parent.getTag());
            }
            else {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_on_list, parent, false);
                return new MyViewHoder(itemView);
            }

        }


        @Override
        public void onBindViewHolder(MyViewHoder holder, int position) {
            Alphabet alphabet = alphabetList.get(position);
            holder.imageView.setImageResource(mPhoto[position]);
        }

        @Override
        public int getItemCount() {
            return alphabetList.size();
        }

        public void addItem(Alphabet alphabet) {


                alphabetList.add(alphabet);
                notifyDataSetChanged();


        }
//        public void setPhoto() {
//            for (int i = 0; i < 28; i++) {
//                mPhoto[i] = getResources().getIdentifier("upper_" + i + ".png", "drawable", getPackageName());
//            }
//        }

//        public void addItem() {
//            for (int i = 0; i < 28; i++) {
//                mPhoto[i] = getResources().getIdentifier("upper_" + i + ".png", "drawable", getPackageName());
//            }
//            notifyDataSetChanged();
//        }
        //getResources().getIdentifier(prefix + i,"raw", rootView.getContext().getPackageName())

    }


}
