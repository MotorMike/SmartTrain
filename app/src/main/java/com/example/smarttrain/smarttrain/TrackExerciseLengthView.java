package com.example.smarttrain.smarttrain;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TrackExerciseLengthView extends AppCompatActivity {

    Exercise exercise;
    LengthExercise lengthExercise;
    //TODO Cancel button, Round edges on boxes, centering for vaule input, space between two lines


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_exercise_length_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        displayExerciseTest();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_track_exercise_length_view, menu);
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


    public void confirmButtonOnClick(View view) {
        //TODO take info and save
        EditText inputEditText = (EditText)findViewById(R.id.inputEditText);
        //TODO input validation
        //lengthExercise.track(inputEditText.getText(), DateStamp);

        CharSequence text = "Exercise Tracked";
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();

        //TODO Return to last page
    }


    //Get exercise from data base
    public void loadExercise() {
        displayExercise();
    }

    //
    public void displayExercise() {

        TextView valueTextView = (TextView) findViewById(R.id.valueTextView);
        TextView unitTextView = (TextView) findViewById(R.id.unitTextView);
        TextView unitsTextView2 = (TextView) findViewById(R.id.unitsTextView2);
        TextView exerciseNameTextView = (TextView) findViewById(R.id.exerciseNameTextView);
        TextView textDescriptionTextView = (TextView) findViewById(R.id.exerciseDescriptionTextView);

        unitTextView.setText(lengthExercise.getUnit());
        unitsTextView2.setText(lengthExercise.getUnit());
        exerciseNameTextView.setText(lengthExercise.getName());
        textDescriptionTextView.setText(lengthExercise.getDescription());

    }

    public void displayExerciseTest() {
        lengthExercise = new LengthExercise("Run", "One leg infront of the other", "Kilometers");
        displayExercise();

    }


}
