package com.example.smarttrain.smarttrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AddExerciseTo extends AppCompatActivity {

    ListView exerciseListView;
    ArrayList exerciess;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise_to);

        dbHelper = new DBHelper(this);
        exerciseListView = (ListView) findViewById(R.id.exerciseListView);
        exerciess = dbHelper.exerciseNameToArrayList();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                exerciess);

        exerciseListView.setAdapter(arrayAdapter);

        exerciseListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(position));
                        Log.d("AddExerciseTo", item + " Item selected");
                        //Toast.makeText(AddExerciseTo.this, "Yo u clicked ", Toast.LENGTH_LONG).show();
                        loadExerciseBuilder(item);
                        // TODO Return exercise id
                    }
                }
        );
    }

    private void loadExerciseBuilder(String item) {
        //If item is reps do this
        Intent intent = new Intent(AddExerciseTo.this, PlanSetExercise.class);
        intent.putExtra("ExerciseName", item);
        startActivityForResult(intent, 2);


        /*
        //If item is length do this
        Intent intent = new Intent(AddExerciseTo.this, PlanLengthExercise.class);
        intent.putExtra("ExerciseName", item);
        startActivityForResult(intent, 2);
        */

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                String message = data.getStringExtra("MESSAGE");
                Intent intentMessage = new Intent();
                intentMessage.putExtra("MESSAGE", message);
                setResult(RESULT_OK, intentMessage);
                finish();
            }
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_exercise_to, menu);
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
