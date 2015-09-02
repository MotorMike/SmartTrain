package com.example.smarttrain.smarttrain;

/**
 * Created by kelseyhyde on 22/08/15.
 */
public class Exercise {
    private String name;
    private String description;
    private int value;
    private int unit;

    public Exercise(String name) {
        this.name = name;
    }

    public Exercise( String name, String description, int unit ){
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.value = 0;
    }

    public Exercise( String name, String description, int value, int unit ){
        this.name = name;
        this.description = description;
        this.value = value;
        this.unit = unit;
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription( String description ){
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void incrementValue(){
        value++;
    }

    public void decrementValue(){
        value--;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
