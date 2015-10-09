package com.example.smarttrain.smarttrain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


/**
 * Created by Mike on 27/08/2015.
 * This class is to add in data persistence
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";

    //DB
    private static final String DB_NAME = "smartTrain.db";
    private static final int DB_VERSION = 7;

    //Table Exercise
    public static final String TABLE_EXERCISE = "EXERCISE";
    private static final String COLUMN_E_ID = "Exercise_id";
    private static final String COLUMN_E_NAME = "Exercise_name";
    private static final String COLUMN_E_DESCRIPTION = "Exercise_description";
    private static final String COLUMN_E_TYPE = "Exercise_type";

    //Table LengthExercise
    public static final String TABLE_LENGTH_EXERCISE = "LengthExercise";
    private static final String COLUMN_L_E_ID = "LengthExercise_id";
    private static final String COLUMN_L_E_LENGTH = "LengthExercise_length";
    private static final String COLUMN_L_E_UNIT = "LengthExercise_unit";
    private static final String COLUMN_L_E_EXERCISE_ID = "Exercise_id";

    //Table RepetitionExercise
    public static final String TABLE_REPETITION_EXERCISE = "RepetitionExercise";
    private static final String COLUMN_R_E_ID = "RepetitionExercise_id";
    private static final String COLUMN_R_E_EXERCISE_ID = "Exercise_id";
    private static final String COLUMN_R_E_PLACE = "PlaceCounter";
    private static final String COLUMN_R_E_SETINFO_ID = "SetInfo_id";

    //Table SetInfo
    public static final String TABLE_SETINFO = "SetInfo";
    private static final String COLUMN_S_ID = "Set_id";
    private static final String COLUMN_S_POSITION = "PositionNumber";
    private static final String COLUMN_S_REP = "RepAmount";
    private static final String COLUMN_S_WEIGHT = "RepWeight";
    private String descriptionByName;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }


    //TODO Constraints to be made constant
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(queryExerciseTable());
        db.execSQL(queryLengthExerciseTable());
        db.execSQL(queryRepetitionExerciseTable());
        db.execSQL(querySetInfoTable());
        Log.d(TAG, "onCreate Called");
    }

    public void queryCheck(long result) {
        if (result != -1) {
            System.out.println(TAG + "Query check results PASS");
        } else {
            System.out.println(TAG + "Query check results FAILED");
        }
    }

    public String queryExerciseTable() {
        //Table Exercise
        String queryExercise = "CREATE TABLE " + TABLE_EXERCISE + "(" +
                COLUMN_E_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_E_NAME + " TEXT, " +
                COLUMN_E_DESCRIPTION + " TEXT, " +
                COLUMN_E_TYPE + " TEXT " +
                ");";
        return queryExercise;
    }

    public String queryLengthExerciseTable() {
        //Table LengthExercise
        String queryLengthExercise = "CREATE TABLE " + TABLE_LENGTH_EXERCISE + "(" +
                COLUMN_L_E_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_L_E_LENGTH + " DOUBLE, " +
                COLUMN_L_E_UNIT + " TEXT, " +
                COLUMN_L_E_EXERCISE_ID + " INTEGER NOT NULL " +
                ");";
        return queryLengthExercise;
    }

    public String queryRepetitionExerciseTable() {
        //Table RepetitionExercise
        String queryRepetitionExercise = "CREATE TABLE " + TABLE_REPETITION_EXERCISE + "(" +
                COLUMN_R_E_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_R_E_EXERCISE_ID + " INTEGER, " +
                COLUMN_R_E_SETINFO_ID + " INTEGER , " +
                COLUMN_R_E_PLACE + " INTEGER " +
                ");";
        return queryRepetitionExercise;
    }

    public String querySetInfoTable() {
        //Table SetInfo
        String querySetInfo = "CREATE TABLE " + TABLE_SETINFO + "(" +
                COLUMN_S_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_S_POSITION + " TEXT, " +
                COLUMN_S_REP + " INTEGER, " +
                COLUMN_S_WEIGHT + " DOUBLE " +
                ");";
        return querySetInfo;
    }

    //Add a new Exercise row to the Exercise table
    public int addExerciseValues(Exercise exercise) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        values.put(COLUMN_E_NAME, exercise.getName());
        values.put(COLUMN_E_DESCRIPTION, exercise.getDescription());
        values.put(COLUMN_E_TYPE, exercise.getType());

        long result = db.insert(TABLE_EXERCISE, null, values);
        db.close();

        return (int) result;
    }

    public void addLengthExercise(LengthExercise exercise) {
        int id = addExerciseValues(exercise);

        ContentValues values = new ContentValues();
        values.put(COLUMN_L_E_LENGTH, exercise.getLength());
        values.put(COLUMN_L_E_UNIT, exercise.getUnit());
        values.put(COLUMN_L_E_EXERCISE_ID, id);
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_LENGTH_EXERCISE, null, values);
        db.close();
        queryCheck(result);
        System.out.println("Result addLengthExercise" + result);
    }

    public void addRepetitionExercise(RepetitionExercise e) {

        int id = addExerciseValues(e);
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        values.put(COLUMN_R_E_PLACE, e.placeCounter);
        values.put(COLUMN_R_E_EXERCISE_ID, id);
        long result = db.insert(TABLE_REPETITION_EXERCISE, null, values);
        db.close();
        queryCheck(result);
        System.out.println("Result addRepetitionExercise" + result);

    }


    public int addSets(RepetitionExercise exercise, int id) {
     /*   SQLiteDatabase db = this.getWritableDatabase();

        for(Set s: exercise.getSets()){
            ContentValues values = new ContentValues();
            values.put(COLUMN_S_POSITION, s.getPlace());
            values.put(COLUMN_S_REP, s.getRepetitions());
            values.put(COLUMN_S_WEIGHT, s.getWeight());
            values.put(COLUMN_S_ID, id);
            long result = db.insert(TABLE_SETINFO, null, values);
            db.close();
        }



        db.close();*/
        int result = 0;
        return (int) result;
    }


    //Delete an Exercise from the Exercise table by id
    public void deleteExerciseByID(int exerciseID) {
        long result;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_EXERCISE + " WHERE " + COLUMN_E_ID + "=\"" + exerciseID + "\";");
        db.execSQL("DELETE FROM " + TABLE_LENGTH_EXERCISE + " WHERE " + COLUMN_L_E_EXERCISE_ID + "=\"" + exerciseID + "\";");
        db.execSQL("DELETE FROM " + TABLE_REPETITION_EXERCISE + " WHERE " + COLUMN_R_E_EXERCISE_ID + "=\"" + exerciseID + "\";");
        //db.execSQL("DELETE FROM " + TABLE_SETINFO + " WHERE " + COLUMN_E_ID + "=\"" + exerciseID + "\";");
    }


    // Drop tables and recreate on upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LENGTH_EXERCISE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPETITION_EXERCISE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETINFO);
        onCreate(db);
        Log.d(TAG, "onUpgrade Called");
        //TODO Keep info on updates
    }

    // Returns all elements in exercise table as a "\n" separated string
    public String exerciseTableNameToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EXERCISE + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COLUMN_E_NAME)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_E_NAME));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    // Returns all names in exercise table an ArrayList<String>
    public ArrayList<String> exerciseNameToArrayList() {

        ArrayList<String> nameArray = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EXERCISE + " WHERE 1";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COLUMN_E_NAME)) != null) {
                nameArray.add(c.getString(c.getColumnIndex(COLUMN_E_NAME)));
            }
            c.moveToNext();
        }
        db.close();

        return nameArray;
    }

    // Returns all names in exercise table an ArrayList<String>
    public String[] exerciseNameToArray() {

        ArrayList<String> list = exerciseNameToArrayList();
        String[] nameArray = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nameArray[i] = list.get(i);
        }

        return nameArray;
    }


    public String exerciseIDtoName(int id) {
        String name = "Name not found";
        String query = "SELECT " + COLUMN_E_NAME + " FROM " + TABLE_EXERCISE +
                " WHERE " + COLUMN_E_ID + " = " + id + ";";
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                name = c.getString(0);
            } while (c.moveToNext());
        }

        return name;
    }

    public int exerciseNameToID(String exName) {
        int id = 0;
        String query = "SELECT " + COLUMN_E_ID + " FROM " + TABLE_EXERCISE +
                " WHERE " + COLUMN_E_NAME + " = \"" + exName + "\";";
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                id = Integer.parseInt(c.getString(0));
            } while (c.moveToNext());
        }
        Log.d("DBHelper", "Exercise Name to ID ExName: " + exName + " ID: " + id);
        return id;
    }


    public String exerciseTypeToString(String exName) {
        String exType = null;

        String query = "SELECT " + COLUMN_E_TYPE + " FROM " + TABLE_EXERCISE +
                " WHERE " + COLUMN_E_NAME + " = \"" + exName + "\";";
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                exType = c.getString(0);
            } while (c.moveToNext());
        }
        Log.d("DBHelper", "Exercise Name to ID ExName: " + exName + " ID: " + exType);
        return exType;

    }


    public String getDescriptionByName(String exName) {
        String description = "";

        String query = "SELECT " + COLUMN_E_DESCRIPTION + " FROM " + TABLE_EXERCISE +
                " WHERE " + COLUMN_E_NAME + " = \"" + exName + "\";";
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                description = c.getString(0);
            } while (c.moveToNext());
        }
        Log.d("DBHelper", "Exercise Name to description: " + exName + " Description: " + description);
        return description;
    }
}
