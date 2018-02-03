package com.paung.popularmovie.Favorite;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by gahar on 03/02/18.
 */

public class FavoriteContract {
    //    The authority,which is how your code knows which Content Provider to access
    static final String AUTHORITY = "com.paung.popularmovie";
    //    identified data in provider
    static final Uri Base_Content_URI = Uri.parse("content://" + AUTHORITY);
    //    path for the "task" directory
    static final String PATH_MOVIES = "movies";

    public static class FavoriteEnt implements BaseColumns {
        public static final Uri CONTENT_URI = Base_Content_URI.buildUpon().
                appendPath(PATH_MOVIES).build();
        public static final String TABLE_NAME = "movies";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_MOVIE_TITLE = "movie_title";
        public static final String COLUMN_MOVIE_OVERVIEW = "movie_overview";
        public static final String COLUMN_MOVIE_VOTE_COUNT = "movie_vote_count";
        public static final String COLUMN_MOVIE_VOTE_AVERAGE = "movie_vote_average";
        public static final String COLUMN_MOVIE_RELEASE_DATE = "movie_release_date";
        public static final String COLUMN_MOVIE_FAV = "movie_favorite";
        public static final String COLUMN_MOVIE_POSTER_PATH = "movie_poster_path";
        public static final String COLUMN_MOVIE_BACKDROP_PATH = "movie_backdrop_path";
    }

}
