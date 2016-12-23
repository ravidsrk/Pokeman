package com.suhaas.pokeman.data.local;


import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

public class DatabaseWrapper {
    private final String TAG = DatabaseWrapper.class.getSimpleName();

    private final Context mContext;

    public DatabaseWrapper(Context context) {
        mContext = context;
    }

    public void addPokeman(String name, String url, String baseStat, String spriteImage, String statName) {
            ContentValues values = new ContentValues();

             values.put(PokemanContract.ListEntry.COLUMN_POKEMAN_NAME, name);
             values.put(PokemanContract.ListEntry.COLUMN_POKEMAN_URL, url);
             values.put(PokemanContract.DetailEntry.COLUMN_POKEMAN_BASE_STAT, baseStat);
             values.put(PokemanContract.DetailEntry.COLUMN_SPRITE_URL, spriteImage);
             values.put(PokemanContract.DetailEntry.COLUMN_STAT_NAME, statName);

            Uri insertedUri = mContext.getContentResolver().insert(
                    PokemanContract.ListEntry.CONTENT_URI,
                    values);
            Uri insertedUri1 = mContext.getContentResolver().insert(
                    PokemanContract.DetailEntry.CONTENT_URI,
                    values);
    }
}
