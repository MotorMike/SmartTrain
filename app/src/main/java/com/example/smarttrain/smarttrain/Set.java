package com.example.smarttrain.smarttrain;

/**
 * Created by kelseyhyde on 10/09/15.
 */
public class Set {
    int place;
    int repetitions;
    double weight;

    Set(int place, int repetitions){
        this.repetitions = repetitions;
        weight = 0;
        this.place = place;
    }

    Set(int place, int repetitions, double weight){
        this.repetitions = repetitions;
        this.weight = weight;
        this.place = place;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
