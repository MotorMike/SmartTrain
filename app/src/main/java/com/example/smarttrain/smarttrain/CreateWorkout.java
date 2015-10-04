package com.example.smarttrain.smarttrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateWorkout extends Activity {

    String[] testItems;
    final static int resultID = 0;
    ArrayList exercisesInWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);
        exercisesInWorkout = new ArrayList<String>();
        //loadTestItems();
        setCallBack();
    }

    private void setCallBack() {
        ListView exerciseListView = (ListView) findViewById(R.id.exerciseListView);
        exerciseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                View clickedExercise = viewClicked;
                Toast.makeText(CreateWorkout.this, clickedExercise.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadTestItems() {
        /*testItems = new String[]{"1", "2", "3", "4"};
        ListAdapter exerciseList = new CustomExerciseViewAdapter(this, testItems);
        ListView exerciseListView = (ListView) findViewById(R.id.exerciseListView);
        exerciseListView.setAdapter(exerciseList);
    */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_workout, menu);
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

    public void saveWorkoutOnClick(View view) {
        Toast.makeText(CreateWorkout.this, "Workout saved message", Toast.LENGTH_SHORT).show();
        //TODO save + save confirmation + Saved icon?
    }

    public void addExercise(View view) {
        Intent intent = new Intent(this, AddExerciseTo.class);
        startActivityForResult(intent, 2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        TextView nameInputEditText = (TextView) findViewById(R.id.nameInputEditText);

        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                String message = data.getStringExtra("MESSAGE");
                nameInputEditText.setText(message);
            }
        }


    }


    public void xButton(View view) {
        Toast.makeText(CreateWorkout.this, "X Button pressed", Toast.LENGTH_SHORT).show();
        //TODO pop up, confirm and delete item picked
    }

    public void exerciseView(View view) {
        TextView item = (TextView) view;
        String message = "Takes you exercise view";
        Toast.makeText(CreateWorkout.this, message, Toast.LENGTH_SHORT).show();
        //TODO take to exercise view
    }

    public void exerciseView(View view, int id) {
        TextView item = (TextView) view;

        Toast.makeText(CreateWorkout.this, id, Toast.LENGTH_SHORT).show();
        //TODO take to exercise view
    }


}
