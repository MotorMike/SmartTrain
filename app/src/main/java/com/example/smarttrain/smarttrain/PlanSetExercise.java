package com.example.smarttrain.smarttrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlanSetExercise extends AppCompatActivity {


    //RepetitionExercise repetitionExercise;
    ListView plannedSetsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_set_exercise);

        RepetitionExercise repetitionExercise = new RepetitionExercise("Name here", "Default");
        repetitionExercise.addSet(1, 11.11);
        //repetitionExercise.addSet(2, 22.22);
        //repetitionExercise.addSet(3, 33.33);

        ArrayList<Set> al = repetitionExercise.getSets();

        plannedSetsListView = (ListView) findViewById(R.id.plannedSetsListView);
        CustomSetBuildAdapter customSetBuildAdapter = new CustomSetBuildAdapter(this, al);
        plannedSetsListView.setAdapter(customSetBuildAdapter);
        TextView exNameTextView = (TextView) findViewById(R.id.exNameTextView);
        exNameTextView.setText(repetitionExercise.getName());
    }

    public void addSetOnclick(View view) {
        View nextSet = getLayoutInflater().inflate(R.layout.custom_view_set_builder, null);
        plannedSetsListView.addView(nextSet);

        Toast.makeText(PlanSetExercise.this, "addSetOnclick worked", Toast.LENGTH_LONG).show();


    }

    private void updateView() {

    }

   /* private void setUpListView() {
        ArrayList repetitionExerciseSets = repetitionExercise.getSets();


        CustomSetBuildAdapter exerciseList;
        exerciseList = new CustomSetBuildAdapter(this, repetitionExerciseSets);

        plannedSetsListView.setAdapter(exerciseList);

        //Name
        TextView exNameTextView = (TextView) findViewById(R.id.ExNameTextView);
        exNameTextView.setText(repetitionExercise.getName());

    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_plan_set_exercise, menu);
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

}
