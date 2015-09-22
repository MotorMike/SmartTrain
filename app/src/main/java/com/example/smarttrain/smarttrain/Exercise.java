package com.example.smarttrain.smarttrain;

import android.content.Context;

/**
 * Created by kelseyhyde on 22/08/15.
 */
abstract public class Exercise {
    private String name;
    private String description;


    public Exercise() {
        name = "";
        description = "";
    }

    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    abstract void addToDataBase(Context context);

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


}
