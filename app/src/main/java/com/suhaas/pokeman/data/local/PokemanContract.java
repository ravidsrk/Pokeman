package com.suhaas.pokeman.data.local;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.format.Time;

import com.suhaas.pokeman.Constants;

public class PokemanContract {

    public static final String CONTENT_AUTHORITY = "com.suhaas.pokeman";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_LIST = ListEntry.TABLE_NAME;
    public static final String PATH_DETAIL = DetailEntry.TABLE_NAME;

    public static long normalizeDate(long startDate) {
        Time time = new Time();
        time.set(startDate);
        int julianDay = Time.getJulianDay(startDate, time.gmtoff);
        return time.setJulianDay(julianDay);
    }

    public static final class ListEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_LIST).build();
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_LIST;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_LIST;


        public static final String TABLE_NAME = "pokemanList";

        public static final String COLUMN_POKEMAN_NAME = Constants.List.POKEMAN_NAME;
        public static final String COLUMN_POKEMAN_URL = Constants.List.POKEMAN_URL;

        public static String TAG = ListEntry.class.getSimpleName();

        public static Uri buildListUriByTitle(String title) {
            return CONTENT_URI.buildUpon()
                    .appendPath(title).build();
        }

        public static String getListIdOrTitleFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }

    public static final class DetailEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_DETAIL).build();
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DETAIL;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DETAIL;

        public static final String TABLE_NAME = "pokemanDetail";
        public static final String COLUMN_POKEMAN_BASE_STAT = Constants.Detail.POKEMAN_BASE_STAT;
        public static final String COLUMN_STAT_NAME = Constants.Detail.STAT_NAME;
        public static final String COLUMN_SPRITE_URL = Constants.Detail.SPRITE_URL;

        public static Uri buildDetailUriByTitle(String title) {
            return CONTENT_URI.buildUpon()
                    .appendPath(title).build();
        }

        public static String getDetailIdOrTitleFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }
}

