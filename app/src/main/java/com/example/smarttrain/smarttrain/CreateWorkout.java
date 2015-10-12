package com.example.smarttrain.smarttrain;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


//TODO when all is deleted from planned list not showing as clear most likey the null check
//TODO menu bar not showing
public class CreateWorkout extends AppCompatActivity {

    ArrayList<String> exercisesInWorkout;
    ListView exerciseListView;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        exercisesInWorkout = new ArrayList<String>();
        exerciseListView = (ListView) findViewById(R.id.exerciseListView);
        dbHelper = new DBHelper(this);
        updateView();
        loadCallBackListener();

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
        super.onActivityResult(requestCode, resultCode, data);

        TextView nameInputEditText = (TextView) findViewById(R.id.nameInputEditText);

        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                String message = data.getStringExtra("MESSAGE");
                exercisesInWorkout.add(message);
            }
        }
        updateView();
    }


    private void loadCallBackListener() {
        exerciseListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        long viewId = view.getId();

                        if (viewId == R.id.removeExButton) {
                            String exName = String.valueOf(parent.getItemAtPosition(position));
                            deleteConfirmPopup(exName);
                        } else if (viewId == R.id.exNameTextView) {
                            String item = String.valueOf(parent.getItemAtPosition(position));
                            //viewExercise(item);
                        }
                    }
                }
        );
    }

    public void deleteConfirmPopup(final String exName) {
        AlertDialog.Builder alert = new AlertDialog.Builder(CreateWorkout.this);
        alert.setTitle("Alert");
        alert.setMessage("Would you like to remove " + exName + " from list?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(CreateWorkout.this, "Exercise Removed", Toast.LENGTH_SHORT).show();
                exercisesInWorkout.remove(exName);
                updateView();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(CreateWorkout.this, "Item not removed", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();

    }

    public void updateView() {
        if (!exercisesInWorkout.isEmpty()) {
            String[] exNames = new String[exercisesInWorkout.size()];
            exNames = exercisesInWorkout.toArray(exNames);

            ListAdapter adapter = new CustomExerciseViewAdapter(this, exNames);
            exerciseListView.setAdapter(adapter);
        }
    }

}
