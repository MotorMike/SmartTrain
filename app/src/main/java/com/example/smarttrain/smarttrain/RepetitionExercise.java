package com.example.smarttrain.smarttrain;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by kelseyhyde on 8/09/15.
 */
public class RepetitionExercise extends Exercise {
    ArrayList<Set> sets;
    int placeCounter;
    private static final String TAG = "RepetitionExercise";

    RepetitionExercise(String name, String description) {
        super(name, description,"Repetition");
        sets = new ArrayList<Set>();
        placeCounter = 0;
    }

    @Override
    void addToDataBase(Context context) {
        DBHelper db = new DBHelper(context);
        db.addRepetitionExercise(this);
        Log.d(TAG, " addToDataBase");
    }

    public void addSet(int repetitions, double weight) {
        sets.add(new Set(placeCounter, repetitions, weight));
        placeCounter++;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }


    public void deleteSet(int place) {
        for (Set s : sets) {
            if (s.getPlace() == place) {
                sets.remove(s);
            }
        }
    }


}
