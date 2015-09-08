package com.example.smarttrain.smarttrain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Mike on 27/08/2015.
 * This class is to add in data persistence
 */
public class DBHelper extends SQLiteOpenHelper {

    //DB
    private static final String DB_NAME = "smartTrain.db";
    private static final int DB_VERSION = 2;

    //Table Exercise
    public static final String TABLE_EXERCISE = "EXERCISE";
    private static final String COLUMN_E_ID = "_id";
    private static final String COLUMN_E_NAME = "_name";
    private static final String COLUMN_E_VALUE = "_value";
    private static final String COLUMN_E_UNIT = "_unit";
    private static final String COLUMN_E_DESCRIPTION = "_description";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Exercise Table
        String queryExercise = "CREATE TABLE " + TABLE_EXERCISE + "(" +
                COLUMN_E_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_E_NAME + " TEXT, " +
                COLUMN_E_VALUE + " INTEGER, " +
                COLUMN_E_UNIT + "TEXT, " +
                COLUMN_E_DESCRIPTION + " TEXT " +
                ");";
        db.execSQL(queryExercise);

    }

    //Add a new Exercise row to the Exercise table
    public void addExercise(Exercise exercise) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_E_NAME, exercise.getName());
        //values.put(COLUMN_E_VALUE, exercise.getValue());
        //values.put(COLUMN_E_UNIT, exercise.getUnit());
        values.put(COLUMN_E_DESCRIPTION, exercise.getDescription());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_EXERCISE, null, values);
        db.close();
    }

    //Delete an Exercise from the Exercise table
    public void deleteExercise(String exerciseName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_EXERCISE + " WHERE " + COLUMN_E_NAME + "=\"" + exerciseName + "\";");
    }


    // Drop tables and recreate on upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISE);
        onCreate(db);
    }

    // Returns all elements in exercise table as a "\n" separated string
    public String exerciseNameTableToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EXERCISE + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("productname")) != null) {
                dbString += c.getString(c.getColumnIndex("productname"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}
