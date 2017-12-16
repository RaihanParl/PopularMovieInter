package com.paung.popularmovie.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.paung.popularmovie.Model.ModelMovie;
import com.paung.popularmovie.R;

import java.util.List;


/**
 * Created by mkddr on 16/12/17.
 */

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private final List<ModelMovie.ResultMovie> modelMovie;
    Context c;

    public AdapterHome(List<ModelMovie.ResultMovie> modelMovie, Context c) {
        this.modelMovie = modelMovie;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelMovie.ResultMovie resultMovie = modelMovie.get(position);
        holder.textList.setText(modelMovie.get(position).title);
        Glide.with(c).load(resultMovie.getPoster()).
                into(holder.imageList);
    }

    @Override
    public int getItemCount() {
        Log.d("SIZE MOVIE", "getItemCount: " + modelMovie.size());
        return modelMovie.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageList;
        TextView textList;
        public ViewHolder(View itemView) {
            super(itemView);
            imageList = itemView.findViewById(R.id.image_list);
            textList = itemView.findViewById(R.id.text_list);
        }
    }
}
