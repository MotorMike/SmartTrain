package com.example.smarttrain.smarttrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


//TODO clear screen/finish activity or inform user exercise was saved, Trim input?

public class CreateExercise extends AppCompatActivity {

    EditText nameInputEditText;
    EditText descriptionInputEditText;
    EditText unitsInputEditText;
    RadioButton distanceRadio;
    RadioButton setsRadio;
    RadioButton timeRadio;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);

        nameInputEditText = (EditText) findViewById(R.id.nameInputEditText) ;
        descriptionInputEditText = (EditText) findViewById(R.id.descriptionInputEditText);
        unitsInputEditText = (EditText) findViewById(R.id.unitsInputEditText);
        distanceRadio = (RadioButton) findViewById(R.id.distanceRadio);
        setsRadio = (RadioButton) findViewById(R.id.setsRadio);
        timeRadio = (RadioButton) findViewById(R.id.timeRadio);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
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

    public void distanceTimeButtonOnClick (View view){
        findViewById(R.id.textView20).setVisibility(View.VISIBLE);
        findViewById(R.id.editText).setVisibility(View.VISIBLE);
    }

    public void setsButtonOnClick (View view){
        findViewById(R.id.textView20).setVisibility(View.GONE);
        findViewById(R.id.editText).setVisibility(View.GONE);
    }

    public void newExerciseCreateButtonOnClick (View view){

        String eName = nameInputEditText.getText().toString();
        String eDescription = descriptionInputEditText.getText().toString();

        nameInputEditText.setError(null);
        descriptionInputEditText.setError(null);
        distanceRadio.setError(null);

        if(isValid(eName, eDescription, radioGroup)){
            if(distanceRadio.isChecked()){
                String eUnit = unitsInputEditText.getText().toString();
                LengthExercise exercise = new LengthExercise(eName, eDescription, eUnit);
                exercise.addToDataBase(this);
            }
            else if(timeRadio.isChecked()){
                String eUnit = unitsInputEditText.getText().toString();
                LengthExercise exercise = new LengthExercise(eName, eDescription, eUnit);
                exercise.addToDataBase(this);
            }
            else if(setsRadio.isChecked()){
                RepetitionExercise exercise = new RepetitionExercise(eName, eDescription);
                exercise.addToDataBase(this);
            }

            Toast.makeText(CreateExercise.this, "Exercise Created", Toast.LENGTH_SHORT).show();

            if (nameInputEditText != null) nameInputEditText.setText(null);
            if (descriptionInputEditText != null) descriptionInputEditText.setText(null);
            if (unitsInputEditText != null) unitsInputEditText.setText(null);
            radioGroup.clearCheck();

        }
        else {
            Toast.makeText(CreateExercise.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
        }

        //When the exercise is built take user to exercise view
        //Intent intent = new Intent(this, viewExercise.class);
        //intent.putExtra(exerciseID,int id);
        //startActivity(intent);
    }


    //TODO add validation to check name is unique.
    private boolean isValid(String name, String description, RadioGroup radioGroup){
        boolean isValid = true;

        if (!isValidName(name)) {
            nameInputEditText.setError("A name is required and must be at least 3 characters long.");
            isValid = false;
        }

        if (!isValidDescription(description)) {
            descriptionInputEditText.setError("A description cannot be more than 240 characters.");
            isValid = false;
        }

        if (!isValidRadio(radioGroup)) {
            distanceRadio.setError("A tracking option must be selected.");
            isValid = false;
        }

        return isValid;
    }

    private boolean isValidName(String name){
        if (name != null && name.length() >= 3) {
            return true;
        }
        return false;
    }

    private boolean isValidDescription(String description){
        if (description.length() < 240) {
            return true;
        }
        return false;
    }

    private boolean isValidRadio(RadioGroup radioGroup){
        if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
            return true;
        }
        return false;
    }

    private boolean isValidUnit(String unit){

    }

}
