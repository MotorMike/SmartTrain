package com.example.smarttrain.smarttrain;

/**
 * Created by kelseyhyde on 8/09/15.
 */
public class SetsExercise extends Exercise {
    int reps;
    int sets;
    int weight;

    SetsExercise(String name, String description){
        super(name, description);
        reps = 0;
        sets = 0;
        weight = 0;
    }

    SetsExercise(String name, String description, int reps, int sets, int weight){
        super(name, description);
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
