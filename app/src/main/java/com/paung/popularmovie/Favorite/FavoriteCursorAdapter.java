package com.paung.popularmovie.Favorite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.paung.popularmovie.R;

public class FavoriteCursorAdapter extends RecyclerView.Adapter<FavoriteCursorAdapter.TaskViewHolder> {

    private Cursor mCursor;
    private Context mContext;

    public FavoriteCursorAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.adapter_home, parent, false);

        return new TaskViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TaskViewHolder holder, final int position) {
        int idIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt._ID);
        int idIndexMovie = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_ID);
         int titleIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_TITLE);
        int OverviewIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_OVERVIEW);
         int averageIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_VOTE_AVERAGE);
         int countIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_VOTE_COUNT);
        int backdropIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_BACKDROP_PATH);
        int posterIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_POSTER_PATH);
        int releaseIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_RELEASE_DATE);
        int favIndex = mCursor.getColumnIndex(FavoriteContract.FavoriteEnt.COLUMN_MOVIE_FAV);
        mCursor.moveToPosition(position);

        final int id = mCursor.getInt(idIndex);
        final int idMovie = mCursor.getInt(idIndexMovie);
        String stitleIndex = mCursor.getString(titleIndex);
        final String sOverviewIndex = mCursor.getString(OverviewIndex);
        final String sbackdropIndex = mCursor.getString(backdropIndex);
        final String sposterIndex = mCursor.getString(posterIndex);
        final String sreleaseIndex = mCursor.getString(releaseIndex);
        final String sfavIndex = mCursor.getString(favIndex);
        final String SaverageIndex = mCursor.getString(averageIndex);
        final String ScountIndex = mCursor.getString(countIndex);
        final String StitleIndex = mCursor.getString(titleIndex);
        holder.itemView.setTag(id);
        holder.txtTitle.setText(stitleIndex);
        String movie_poster_url =  sposterIndex;
        Glide.with(mContext)
                .load(movie_poster_url)
                .into(holder.imgFav);


    }
    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }

    public Cursor swapCursor(Cursor c) {
        if (mCursor == c) {
            return null;
        }
        Cursor temp = mCursor;
        this.mCursor = c;


        if (c != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }


    class TaskViewHolder extends RecyclerView.ViewHolder {


        TextView txtTitle;
        ImageView imgFav;
        CardView cvFavorite;
        public TaskViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.text_list);
            imgFav = (ImageView) itemView.findViewById(R.id.image_list);
            cvFavorite = (CardView) itemView.findViewById(R.id.cv_home);

        }
    }
}