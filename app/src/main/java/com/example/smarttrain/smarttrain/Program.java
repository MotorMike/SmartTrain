package com.example.smarttrain.smarttrain;

import java.util.HashMap;

/**
 * Created by kelseyhyde on 22/08/15.
 */
public class Program {
    String name;
    String description;
    HashMap<String, Workout> map;

    public Program(String name, String description){
        this.name = name;
        this.description = description;
        map = new HashMap<String, Workout>();
        fillDefaultMap();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean addWorkout(String key, Workout workout){
        if (map.containsKey(key)){
            map.put(key, workout);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeWorkout(String key){
        if (map.containsKey(key)){
            map.remove(key);
            return true;
        }
        else {
            return false;
        }
    }


    private void fillDefaultMap(){
        map.put("Monday", null);
        map.put("Tuesday", null);
        map.put("Wednesday", null);
        map.put("Thursday", null);
        map.put("Friday", null);
        map.put("Saturday", null);
        map.put("Sunday", null);
    }
}
