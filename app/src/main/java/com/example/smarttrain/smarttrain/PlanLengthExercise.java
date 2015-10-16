package com.example.smarttrain.smarttrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
/**
 * Builds length exercises with goals included
 * Has UI
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
public class PlanLengthExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_length_exercise);

        Intent i = getIntent();
        String exName = i.getStringExtra("ExerciseName");
        TextView exNameTextView = (TextView) findViewById(R.id.exNameTextView);
        exNameTextView.setText(exName);

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

    }

    private void updateView() {

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
