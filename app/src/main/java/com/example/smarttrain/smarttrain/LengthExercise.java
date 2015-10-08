package com.example.smarttrain.smarttrain;

import android.content.Context;

/**
 * Created by kelseyhyde on 8/09/15.
 */
public class LengthExercise extends Exercise {
    private static final String TAG = "LengthExercise";

    double length;
    String unit;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    LengthExercise(String name, String description, String unit) {
        super(name, description, "Length");
        this.unit = unit;
        this.length = 0.00;
    }

    LengthExercise(String name, String description, String unit, double time) {
        super(name, description, "Time");
        this.unit = unit;
        this.length = time;
    }

    public double getTime() {
        return length;
    }

    public void setTime(double time) {
        this.length = time;
    }

    public void incrementTime() {
        length++;
    }

    public void decrementTime() {
        length--;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Override
    void addToDataBase(Context context) {
        DBHelper db = new DBHelper(context);
        db.addLengthExercise(this);
        System.out.println(TAG + " addToDataBase");
    }
}
