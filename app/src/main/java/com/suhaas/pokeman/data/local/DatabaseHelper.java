package com.suhaas.pokeman.data.local;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.suhaas.pokeman.data.model.PokemanResponse;
import com.suhaas.pokeman.data.model.list.Results;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "pokemanDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_POKEMAN = "pokeman";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_STAT_NAME = "name";
    private static final String COLUMN_BASE_STAT = "base_stat";
    private static final String COLUMN_SPRIRES_URL = "url";


    private static DatabaseHelper sInstance;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
//        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POKEMAN_TABLE = "CREATE TABLE " + TABLE_POKEMAN +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_STAT_NAME + " TEXT," +
                COLUMN_BASE_STAT + " INTEGER," +
                COLUMN_SPRIRES_URL + " TEXT" +
                ")";

        db.execSQL(CREATE_POKEMAN_TABLE);
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_POKEMAN);
            onCreate(db);
        }
    }

    public void addPokeman(PokemanResponse response) {
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(COLUMN_STAT_NAME, response.getName());
            values.put(COLUMN_BASE_STAT, response.getStats().get(0).getBaseStat());
            values.put(COLUMN_SPRIRES_URL, response.getSprites().getFrontShiny());
            db.insertOrThrow(TABLE_POKEMAN, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("Error while trying to add results to database", e.getMessage());
        } finally {
            db.endTransaction();
        }
    }

    public List<Results> getAllResults(String pokemanName) {
        List<Results> results = new ArrayList<>();

        String RESULTS_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = '%s' AND %s > 0",
                        TABLE_POKEMAN, COLUMN_STAT_NAME, pokemanName, COLUMN_BASE_STAT);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESULTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
//                    Stat newResult = new Stat();
//                    newResult.getName() = cursor.getString(cursor.getColumnIndex(COLUMN_STAT_NAME));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("Error while trying to get results from database", e.getMessage());
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return results;
    }

    public void removeAllResults() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            // Order of deletions is important when foreign key relationships exist.
            db.delete(TABLE_POKEMAN, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("Error while trying to delete all results", e.getMessage());
        } finally {
            db.endTransaction();
        }
    }
}
