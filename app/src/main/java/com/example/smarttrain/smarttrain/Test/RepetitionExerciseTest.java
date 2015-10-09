package com.example.smarttrain.smarttrain.Test;

import com.example.smarttrain.smarttrain.Exercise;
import com.example.smarttrain.smarttrain.RepetitionExercise;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mike on 8/10/2015.
 */
public class RepetitionExerciseTest {

    String testName;
    String testDescription;
    String testType;
    Exercise testExercise;


    @Before
    public void setUp() throws Exception {
        String testName = "Exercise name";
        String testDescription = "Exercise Description";
        String testType = "Repetition";;
        Exercise testExercise = new RepetitionExercise(testName,testDescription);
    }

    @Test
    public void testAddToDataBase() throws Exception {

    }

    @Test
    public void testAddSet() throws Exception {

    }

    @Test
    public void testGetSets() throws Exception {

    }

    @Test
    public void testDeleteSet() throws Exception {

    }

    @Test
    public void testAddToDataBase1() throws Exception {

    }

    @Test
    public void testGetName() throws Exception {
        if(testExercise.getName().equals(testName)){
            assert true;
        }else {assert false;}
    }

    @Test
    public void testSetName() throws Exception {

    }

    @Test
    public void testGetDescription() throws Exception {

    }

    @Test
    public void testSetDescription() throws Exception {

    }

    @Test
    public void testGetType() throws Exception {

    }

    @Test
    public void testSetType() throws Exception {

    }
}