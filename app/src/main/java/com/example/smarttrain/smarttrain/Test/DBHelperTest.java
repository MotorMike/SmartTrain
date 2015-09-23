package com.example.smarttrain.smarttrain.Test;

import android.content.Context;

import com.example.smarttrain.smarttrain.DBHelper;

import junit.framework.TestCase;

import org.junit.Test;


/**
 * Created by Mike on 22/09/2015.
 */
public class DBHelperTest extends TestCase {

    @Test
    public void testOnCreate() throws Exception {
        assertTrue(true);
    }

    @Test
    public void testQueryCheck() throws Exception {

    }

    @Test
    public void testQueryExerciseTable() throws Exception {

    }

    @Test
    public void testQueryLengthExerciseTable() throws Exception {

    }

    @Test
    public void testQueryRepetitionExerciseTable() throws Exception {

    }

    @Test
    public void testQuerySetInfoTable() throws Exception {

    }

    @Test
    public void testAddExerciseValues() throws Exception {

    }

    @Test
    public void testAddLengthExercise() throws Exception {

    }

    @Test
    public void testAddRepetitionExercise() throws Exception {

    }

    @Test
    public void testDeleteExercise() throws Exception {

    }



    @Test
    public void testExerciseNameTableToString() throws Exception {

        Context context = null;
        DBHelper db = new DBHelper(context);
        String result = db.exerciseTableNameToString();
        System.out.println(result);
    }
}