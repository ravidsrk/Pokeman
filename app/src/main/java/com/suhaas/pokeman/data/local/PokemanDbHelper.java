package com.suhaas.pokeman.data.local;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.suhaas.pokeman.data.model.Sprites;
import com.suhaas.pokeman.data.model.Stat;
import com.suhaas.pokeman.data.model.Stats;
import com.suhaas.pokeman.data.model.list.Results;

import java.util.ArrayList;
import java.util.List;

public class PokemanDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pokemanDatabase";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_RESULTS = "results";

    // Table Columns
    private static final String KEY_RESULTS_ID = "id";
    private static final String KEY_RESULT_NAME = "name";

    private static final String KEY_POKEMANS_SPRITES = "sprites";
    private static final String KEY_POKEMANS_BASE_STAT = "base";
    private static final String KEY_POKEMANS_STATS = "stats";

    public PokemanDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_RESULTS_TABLE = "CREATE TABLE " + TABLE_RESULTS +
                "(" +
                KEY_RESULTS_ID + " INTEGER PRIMARY KEY, " +
                KEY_RESULT_NAME + " TEXT, " +
                KEY_POKEMANS_SPRITES + " TEXT, " +
                KEY_POKEMANS_BASE_STAT + " INTEGER, " +
                KEY_POKEMANS_STATS + " TEXT);";

        sqLiteDatabase.execSQL(CREATE_RESULTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_RESULTS);
        onCreate(sqLiteDatabase);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     * @param results
     */

    public void addList(List<Results> results) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        for (int i = 0; i < results.size(); i++) {
            values.put(KEY_RESULT_NAME, results.get(i).getName());
        }
        // Inserting Row
        db.insert(TABLE_RESULTS, null, values);
        db.close(); // Closing database connection
    }

    public void addSprites(Sprites sprites) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
            values.put(KEY_POKEMANS_SPRITES, sprites.getFrontShiny());
        // Inserting Row
        db.insert(TABLE_RESULTS, null, values);
        db.close(); // Closing database connection
    }

    public void addStatNames(List<Stats> statsList) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        for (int i = 0; i < statsList.size(); i++) {
            values.put(KEY_POKEMANS_STATS, statsList.get(i).getStat().getName());
        }
        // Inserting Row
        db.insert(TABLE_RESULTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public String getSprites(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_RESULTS, new String[] { KEY_RESULTS_ID,
                KEY_POKEMANS_SPRITES}, KEY_RESULTS_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        String newSprite = cursor.getString(cursor.getColumnIndex(KEY_POKEMANS_SPRITES));
        return newSprite;
    }

    // Getting All Results
    public List<Results> getAllResults() {
        List<Results> resultList = new ArrayList<Results>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RESULTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Results results = new Results();
//                results.set_id(Integer.parseInt(cursor.getString(0)));
                results.setName(cursor.getString(1));
                // Adding results to list
                resultList.add(results);
            } while (cursor.moveToNext());
        }

        // return contact list
        return resultList;
    }

    // Getting All StatsName
    public List<Stats> getAllStatNames() {
        List<Stats> statsList = new ArrayList<Stats>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RESULTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Stats stats = new Stats();
                stats.getStat().setName(cursor.getString(1));
                // Adding results to list
                statsList.add(stats);
            } while (cursor.moveToNext());
        }

        // return contact list
        return statsList;
    }
}
