package com.example.smarttrain.smarttrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * This class is used to navigate to building or editing of
 * Exercises Workouts and Programs
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void exerciseButtonOnClick(View view) {
        Intent intentExercise = new Intent(getBaseContext(), CreateExercise.class);
        startActivity(intentExercise);

    }

    public void exerciseViewOnClick(View view) {
        Intent intentExercise = new Intent(getBaseContext(), ViewExerciseList.class);
        startActivity(intentExercise);

    }

    public void workoutCreateOnClick(View view) {
        Intent intentExercise = new Intent(getBaseContext(), CreateWorkout.class);
        startActivity(intentExercise);
    }


}
