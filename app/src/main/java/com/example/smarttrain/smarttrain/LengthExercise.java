package com.example.smarttrain.smarttrain;

/**
 * Created by kelseyhyde on 8/09/15.
 */
public class LengthExercise extends Exercise {
    double length;
    String unit;

    LengthExercise(String name, String description, String unit){
        super(name, description);
        this.unit = unit;
        this.length = 0.00;
    }

    LengthExercise(String name, String description, String unit, double time){
        super(name, description);
        this.unit = unit;
        this.length = time;
    }

    public double getTime() {
        return length;
    }

    public void setTime( double time ){
        this.length = time;
    }

    public void incrementTime(){
        length++;
    }

    public void decrementTime(){
        length--;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit( String unit ){
        this.unit = unit;
    }
}
