package com.suhaas.pokeman.data.local;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "pokemanDatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POKEMAN_LIST_TABLE = "CREATE TABLE " + PokemanContract.ListEntry.TABLE_NAME +
                "(" +
                PokemanContract.ListEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PokemanContract.ListEntry.COLUMN_POKEMAN_NAME + " TEXT NOT NULL, " +
                PokemanContract.ListEntry.COLUMN_POKEMAN_URL + " TEXT NOT NULL, " +
                ")";

        String CREATE_POKEMAN_DETAIL_TABLE = "CREATE TABLE " + PokemanContract.DetailEntry.TABLE_NAME +
                "(" +
                PokemanContract.DetailEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PokemanContract.DetailEntry.COLUMN_POKEMAN_BASE_STAT + " INTEGER NOT NULL, " +
                PokemanContract.DetailEntry.COLUMN_STAT_NAME + " TEXT NOT NULL, " +
                PokemanContract.DetailEntry.COLUMN_SPRITE_URL + " TEXT NOT NULL, " +
                ")";
        Log.i(TAG, "onCreate: " + CREATE_POKEMAN_LIST_TABLE);
        Log.i(TAG, "onCreate: " + CREATE_POKEMAN_DETAIL_TABLE);
        db.execSQL(CREATE_POKEMAN_LIST_TABLE);
        db.execSQL(CREATE_POKEMAN_DETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + PokemanContract.ListEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + PokemanContract.DetailEntry.TABLE_NAME);
            onCreate(db);
        }
    }
}
