package com.example.smarttrain.smarttrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateExercise extends AppCompatActivity {

    EditText nameInputEditText;
    EditText descriptionInputEditText;
    EditText unitInputEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);


        nameInputEditText = (EditText) findViewById(R.id.nameInputEditText) ;
        descriptionInputEditText = (EditText) findViewById(R.id.descriptionInputEditText);
        unitInputEditText = (EditText) findViewById(R.id.unitInputEditText);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_exercise, menu);
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

    public void newExerciseCreateButtonOnClick (View view){

        String eName = nameInputEditText.getText().toString();
        String eDescription = descriptionInputEditText.getText().toString();
        String eUnit = unitInputEditText.getText().toString();

        if (isValid(eName, eDescription, eUnit)) {
            Exercise exercise = new Exercise(eName, eDescription, eUnit);
            DBHelper db = new DBHelper(this);
            db.addExercise(exercise);
        }

        //When the exercise is built take user to exercise view
        //Intent intent = new Intent(this, viewExercise.class);
        //intent.putExtra(exerciseID,int id);
        //startActivity(intent);
    }

    private boolean isValid(String name, String description, String unit){
        boolean isValid = true;

        if (!isValidName(name)) {
            nameInputEditText.setError("Invalid Name");
            isValid = false;
        }

        if (!isValidDescription(description)) {
            descriptionInputEditText.setError("Invalid Email");
            isValid = false;
        }

        if (!isValidUnit(unit)) {
            unitInputEditText.setError("Invalid Email");
            isValid = false;
        }

        return isValid;
    }

    private boolean isValidName(String name){
        return true;
    }

    private boolean isValidDescription(String decription){
        return true;
    }

    private boolean isValidUnit(String unit){
        return true;
    }
}
