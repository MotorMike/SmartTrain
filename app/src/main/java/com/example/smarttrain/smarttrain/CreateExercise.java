package com.example.smarttrain.smarttrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreateExercise extends AppCompatActivity {

    EditText nameInputEditText;
    EditText descriptionInputEditText;
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

    public void newExerciseCreateButtonOnClick (View view){

        String eName = nameInputEditText.getText().toString();
        String eDescription = descriptionInputEditText.getText().toString();

        nameInputEditText.setError(null);
        descriptionInputEditText.setError(null);
        distanceRadio.setError(null);

        if(isValid(eName, eDescription, radioGroup)){
            if(distanceRadio.isChecked()){
                String eUnit = "metres"; //TODO make distance user input based
                LengthExercise exercise = new LengthExercise(eName, eDescription, eUnit);
                DBHelper db = new DBHelper(this);
                db.addExercise(exercise);
            }
            else if(timeRadio.isChecked()){
                String eUnit = "seconds"; //TODO make time user input based
                LengthExercise exercise = new LengthExercise(eName, eDescription, eUnit);
                DBHelper db = new DBHelper(this);
                db.addExercise(exercise);
            }
            else if(setsRadio.isChecked()){
                RepetitionExercise exercise = new RepetitionExercise(eName, eDescription);
                DBHelper db = new DBHelper(this);
                db.addExercise(exercise);
            }
        }

        //When the exercise is built take user to exercise view
        //Intent intent = new Intent(this, viewExercise.class);
        //intent.putExtra(exerciseID,int id);
        //startActivity(intent);
    }

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
        if (name != null && name.length() > 3) {
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

}
