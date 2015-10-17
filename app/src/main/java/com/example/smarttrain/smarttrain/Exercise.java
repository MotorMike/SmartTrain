package com.example.smarttrain.smarttrain;

import android.content.Context;

/**
 * This class describes a basic Exercise. It is the superclass for LengthExercise and RepetitionExercise.
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
abstract public class Exercise {
    private String name;
    private String description;
    private String type;

    abstract void addToDataBase(Context context);

    public Exercise() {
        name = "";
        description = "";
    }

    public Exercise(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
