package com.tutorials.hp.swiperefreshrecyclerview;

import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Oclemmy on 3/30/2016 for ProgrammingWizards Channel.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Movie> movies;
    SwipeRefreshLayout swiper;

    public MyAdapter(Context c, ArrayList<Movie> movies, SwipeRefreshLayout swiper) {
        this.c = c;
        this.movies = movies;
        this.swiper = swiper;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        MyHolder holder=new MyHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
         holder.nameTxt.setText(movies.get(position).getName());
        holder.img.setImageResource(movies.get(position).getImage());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Toast.makeText(c, movies.get(pos).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        swiper.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    private void refresh()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                movies.add(0,movies.get(new Random().nextInt(movies.size())));

                MyAdapter.this.notifyDataSetChanged();

                swiper.setRefreshing(false);
            }
        },3000);
    }
}
