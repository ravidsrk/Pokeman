package com.suhaas.pokeman.data.local;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.suhaas.pokeman.data.model.list.Results;

import java.util.ArrayList;
import java.util.List;

public class PokemanDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pokemanDatabase";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_RESULTS = "results";
    private static final String TABLE_POKEMANS = "pokemans";

    // Results Table Columns
    private static final String KEY_RESULTS_ID = "id";
    private static final String KEY_RESULT_NAME = "name";
    private static final String KEY_RESULT_URL = "url";

    // Pokemans Table Columns
    private static final String KEY_POKEMANS_ID = "_id";
    private static final String KEY_POKEMANS_SPRITES = "sprites";
    private static final String KEY_USER_PROFILE_PICTURE_URL = "profilePictureUrl";

    public PokemanDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_RESULTS_TABLE = "CREATE TABLE " + TABLE_RESULTS +
                "(" +
                KEY_RESULTS_ID + " INTEGER PRIMARY KEY, " +
                KEY_RESULT_NAME + " TEXT);";

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
        values.put(KEY_RESULT_NAME, results.get(0).getName());

        // Inserting Row
        db.insert(TABLE_RESULTS, null, values);
        db.close(); // Closing database connection
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
//                results.setID(Integer.parseInt(cursor.getString(0)));
                results.setName(cursor.getString(0));
                // Adding results to list
                resultList.add(results);
            } while (cursor.moveToNext());
        }

        // return contact list
        return resultList;
    }
}
