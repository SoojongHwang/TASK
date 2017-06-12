package com.example.kepler.recyclerviewtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context c;

    RecyclerView view;
    MyAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = getApplicationContext();
        view = (RecyclerView)findViewById(R.id.recycler_view);
        view.setHasFixedSize(true);

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(R.drawable.i1, "a"));
        items.add(new Item(R.drawable.i1, "b"));
        items.add(new Item(R.drawable.i1, "c"));
        items.add(new Item(R.drawable.i1, "d"));
        items.add(new Item(R.drawable.i1, "e"));
        items.add(new Item(R.drawable.i1, "f"));
        items.add(new Item(R.drawable.i1, "g"));
        items.add(new Item(R.drawable.i1, "h"));
        items.add(new Item(R.drawable.i1, "i"));

        layoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(layoutManager);

        adapter = new MyAdapter(items);
        view.setAdapter(adapter);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        private ArrayList<Item> items;

        public MyAdapter(ArrayList<Item> items) {
            this.items = items;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            MyViewHolder holder = new MyViewHolder(v);

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.imageView.setImageResource(items.get(position).image);
            holder.textView.setText(items.get(position).title);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            public ImageView imageView;
            public TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.iv);
                textView = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }
}
