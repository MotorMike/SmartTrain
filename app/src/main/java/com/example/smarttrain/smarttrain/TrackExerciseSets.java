package com.example.smarttrain.smarttrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
/**
 * Not implemented
 * Has UI
 * Displays users goal for sets exercise and allows users to enter what was reached
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
public class TrackExerciseSets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_exercise_sets);
        settingUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_track_exercise_sets, menu);
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

    public void settingUp() {
        loadSets();
    }

    public void loadSets() {
        RepetitionExercise re = new RepetitionExercise("Push ups", "Push the earth down");
        re.addSet(99, 99);
        re.addSet(88, 88);
        re.addSet(77, 77);

        TextView exerciseNameTextView = (TextView) findViewById(R.id.TextView);
        TextView exerciseDescriptionTextView = (TextView) findViewById(R.id.exerciseDescriptionTextView);
        exerciseNameTextView.setText(re.getName());
        exerciseDescriptionTextView.setText(re.getDescription());

        ListAdapter setsViewAdapter = new CustomSetViewAdapter(this, re.getSets());
        ListView setsListView = (ListView) findViewById(R.id.setsListView);
        setsListView.setAdapter(setsViewAdapter);

    }


}
