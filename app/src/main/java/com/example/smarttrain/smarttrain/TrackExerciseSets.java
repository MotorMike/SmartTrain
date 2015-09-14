package com.example.smarttrain.smarttrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

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

    public void settingUp(){

        String[] Test = {"Set 1", "Set 2", "Set 3", "Set 5", "Set 6", "Set 7", "Set 8", "Set 9"};
        ListAdapter setsViewAdapter = new CustomSetViewAdapter(this, Test);
        ListView setsListView = (ListView) findViewById(R.id.setsListView);
        setsListView.setAdapter(setsViewAdapter);

        RepetitionExercise re = new RepetitionExercise("Push ups","Push the earth down");
        re.addSet(20,40);
        re.addSet(30,30);




    }

    public void loadSets(RepetitionExercise re){
        /*ListAdapter setsViewAdapter = new CustomSetViewAdapter(this, re);
        ListView setsListView = (ListView) findViewById(R.id.setsListView);
        setsListView.setAdapter(setsViewAdapter);
        */


    }





}
