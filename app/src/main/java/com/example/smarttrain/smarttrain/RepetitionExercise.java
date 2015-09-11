package com.example.smarttrain.smarttrain;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kelseyhyde on 8/09/15.
 */
public class RepetitionExercise extends Exercise {
    ArrayList<Set> sets;
    int placeCounter;

    RepetitionExercise(String name, String description){
        super(name, description);
        sets = new ArrayList<Set>();
        placeCounter = 1;
    }

    public void addSet(int repetitions, double weight){
        sets.add(new Set(placeCounter, repetitions, weight));
        placeCounter++;
    }

    public void deleteSet(int place){
        for (Set s: sets) {
            if (s.getPlace() == place){
                sets.remove(s);
            }
        }
    }
}