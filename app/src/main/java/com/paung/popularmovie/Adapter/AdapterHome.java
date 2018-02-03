package com.paung.popularmovie.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Movie;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.paung.popularmovie.Favorite.FavoriteContract;
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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ModelMovie.ResultMovie resultMovie = modelMovie.get(position);
        holder.textList.setText(resultMovie.title);
        Glide.with(c).load(resultMovie.getPoster()).
                into(holder.imageList);
        holder.cv_home.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ContentValues contentValues = new ContentValues();
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_ID, resultMovie.id);
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_TITLE, resultMovie.title);
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_OVERVIEW, resultMovie.overview);
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_VOTE_AVERAGE, resultMovie.voteAverage);
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_VOTE_COUNT, resultMovie.voteCount);
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_BACKDROP_PATH, resultMovie.backdropPath);
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_POSTER_PATH, resultMovie.getPoster());
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_RELEASE_DATE, resultMovie.releaseDate);
                contentValues.put(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_FAV, "1");
                Uri uri = c.getContentResolver().insert(FavoriteContract.FavoriteEnt.CONTENT_URI, contentValues);
                if (uri != null) {
                    Toast.makeText(c, resultMovie.originalTitle + "has been added to favorite list", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d("SIZE MOVIE", "getItemCount: " + modelMovie.size());
        return modelMovie.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageList;
        TextView textList;
        CardView cv_home;

        public ViewHolder(View itemView) {
            super(itemView);
            imageList = itemView.findViewById(R.id.image_list);
            textList = itemView.findViewById(R.id.text_list);
            cv_home = itemView.findViewById(R.id.cv_home);
        }
    }
//    public void favController(String idEvent,final ViewHolder holder) {
//        String projection[] = {FavoriteContract.FavoriteEnt.COLUMN_MOVIE_ID};
//        Cursor cursor = c.getContentResolver().query(FavoriteContract.FavoriteEnt.CONTENT_URI,
//                projection,
//                FavoriteContract.FavoriteEnt.COLUMN_MOVIE_ID + " = " + idEvent,
//                null,
//                null);
//        if (cursor.getCount() == 0) {
//
//        } else {
//            while (cursor.moveToNext()) {
//                String movieId = cursor.getString(0);
//                if (movieId.equals(idEvent)) {
//
//                }
//            }
//        }
//        cursor.close();
//    }
}
