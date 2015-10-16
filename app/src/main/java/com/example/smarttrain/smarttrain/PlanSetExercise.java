package com.example.smarttrain.smarttrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Builds sets exercises with goals included
 * Has UI
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
public class PlanSetExercise extends AppCompatActivity {


    RepetitionExercise repetitionExercise;
    ListView plannedSetsListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_set_exercise);

        Intent i = getIntent();
        String exName = i.getStringExtra("ExerciseName");
        repetitionExercise = new RepetitionExercise(exName, "Default");
        updateView();

    }


    public void confirmOnclick(View view) {
        TextView exNameTextView = (TextView) findViewById(R.id.exNameTextView);
        String message = exNameTextView.getText().toString();
        Intent intentMessage = new Intent();
        intentMessage.putExtra("MESSAGE", message);
        setResult(RESULT_OK, intentMessage);
        finish();

    }


    public void addSetOnclick(View view) {
        //View nextSet = getLayoutInflater().inflate(R.layout.custom_view_set_builder, null);
        //plannedSetsListView.addView(nextSet);
        //Toast.makeText(PlanSetExercise.this, "addSetOnclick worked", Toast.LENGTH_LONG).show();
        repetitionExercise.addSet(0, 0.00);
        updateView();
    }

    private void updateView() {
        ArrayList<Set> al = repetitionExercise.getSets();
        plannedSetsListView = (ListView) findViewById(R.id.plannedSetsListView);
        CustomSetBuildAdapter customSetBuildAdapter = new CustomSetBuildAdapter(this, al);
        plannedSetsListView.setAdapter(customSetBuildAdapter);
        TextView exNameTextView = (TextView) findViewById(R.id.exNameTextView);
        exNameTextView.setText(repetitionExercise.getName());
    }


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
