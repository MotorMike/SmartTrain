package com.example.smarttrain.smarttrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class validates and creates exercises using an Android interface
 *
 * @author     Kelsey Hyde and Mike Nicholls
 * @version    1.0 (2015)
 */
public class CreateExercise extends AppCompatActivity {

    EditText nameInputEditText;
    EditText descriptionInputEditText;
    EditText unitsInputEditText;
    RadioButton distanceRadio;
    RadioButton setsRadio;
    RadioButton timeRadio;
    RadioGroup radioGroup;
    TextView text;

    DBHelper dbHelper;


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
        text = (TextView) findViewById(R.id.trackingTextView);

        dbHelper = new DBHelper(this);
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
        findViewById(R.id.unitsInputEditText).setVisibility(View.VISIBLE);
    }

    public void setsButtonOnClick (View view){
        findViewById(R.id.textView20).setVisibility(View.GONE);
        findViewById(R.id.unitsInputEditText).setVisibility(View.GONE);
    }

    public void newExerciseCreateButtonOnClick (View view){

        String eName = nameInputEditText.getText().toString();
        String eDescription = descriptionInputEditText.getText().toString();

        nameInputEditText.setError(null);
        descriptionInputEditText.setError(null);
        distanceRadio.setError(null);


        if(isValid(eName, eDescription, radioGroup)){
            if(distanceRadio.isChecked() || timeRadio.isChecked()){
                String eUnit = unitsInputEditText.getText().toString();
                if(isValidUnit(eUnit)){
                    LengthExercise exercise = new LengthExercise(eName, eDescription, eUnit);
                    exercise.addToDataBase(this);

                    Toast.makeText(CreateExercise.this, "Exercise Created", Toast.LENGTH_SHORT).show();
                    clearForm();
                }
                else{
                    unitsInputEditText.setError("A unit is required and must be at least 3 characters long.");
                    Toast.makeText(CreateExercise.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                }

            }
            else if(setsRadio.isChecked()){
                RepetitionExercise exercise = new RepetitionExercise(eName, eDescription);
                exercise.addToDataBase(this);

                Toast.makeText(CreateExercise.this, "Exercise Created", Toast.LENGTH_SHORT).show();
                clearForm();
            }


        }
        else {
            Toast.makeText(CreateExercise.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearForm(){
        if (nameInputEditText != null) nameInputEditText.setText(null);
        if (descriptionInputEditText != null) descriptionInputEditText.setText(null);
        if (unitsInputEditText != null) unitsInputEditText.setText(null);
        radioGroup.clearCheck();
        findViewById(R.id.textView20).setVisibility(View.GONE);
        findViewById(R.id.unitsInputEditText).setVisibility(View.GONE);
    }

    private boolean isValid(String name, String description, RadioGroup radioGroup){
        boolean isValid = true;

        if (!uniqueName(name)){
            nameInputEditText.setError("An exercise with this name already exists.");
            isValid = false;
        }

        if (!isValidName(name)) {
            nameInputEditText.setError("A name is required and must be between 3 and 25 characters in length.");
            isValid = false;
        }

        if (!isValidDescription(description)) {
            descriptionInputEditText.setError("A description cannot be more than 240 characters.");
            isValid = false;
        }

        if (!isValidRadio(radioGroup)) {
            text.setError("A tracking option must be selected.");
            isValid = false;
        }

        return isValid;
    }

    private boolean isValidName(String name){
        if (name != null && name.length() >= 3 && name.length() <= 25) {
            return true;
        }
        return false;
    }

    private boolean isValidDescription(String description){
        if (description.length() <= 240) {
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
        if (unit != null && unit.length() >= 3 && unit.length() <= 25) {
            return true;
        }
        return false;
    }

    private boolean uniqueName(String name){
        String[] exNames = dbHelper.exerciseNameToArray();

        for(int i = 0; i < exNames.length; i++){
            if(name.equals(exNames[i])){
                return false;
            }
        }
        return true;
    }

}
