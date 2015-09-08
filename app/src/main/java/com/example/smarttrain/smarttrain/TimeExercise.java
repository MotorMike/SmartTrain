package com.example.smarttrain.smarttrain;

/**
 * Created by kelseyhyde on 8/09/15.
 */
public class TimeExercise extends Exercise {
    double time;
    String unit;

    TimeExercise( String name, String description, String unit ){
        super(name, description);
        this.unit = unit;
        this.time = 0.00;
    }

    TimeExercise( String name, String description, String unit, double time ){
        super(name, description);
        this.unit = unit;
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime( double time ){
        this.time = time;
    }

    public void incrementTime(){
        time++;
    }

    public void decrementTime(){
        time--;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit( String unit ){
        this.unit = unit;
    }
}
