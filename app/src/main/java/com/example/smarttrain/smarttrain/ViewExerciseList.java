package com.example.smarttrain.smarttrain;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Has UI
 * Shows list of all exercises in data base
 * Links selected Exercise to view exercise
 * Can delete exercise from database
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
public class ViewExerciseList extends AppCompatActivity {

    ListView exerciseListView;
    ArrayList<String> exercises;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise_list);

        dbHelper = new DBHelper(this);
        exerciseListView = (ListView) findViewById(R.id.exerciseListView);
        exercises = new ArrayList<>(dbHelper.exerciseNameToArrayList());


        updateView();
        loadCallBackListener();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_exercise_list, menu);
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

    public void exerciseView(View view) {
        CharSequence text = "Button not implemented";
        Log.d("ViewExerciseList", view.getId() + " Button ID");
        ViewParent newView = view.getParent();
        Log.d("ViewExerciseList", newView.toString() + "Exercise Button parent ID");
        Toast.makeText(ViewExerciseList.this, text, Toast.LENGTH_LONG).show();
    }

    public void xButton(View view) {
        CharSequence text = "X Button not implemented";
        ViewParent newView = view.getParent();
        Log.d("ViewExerciseList", newView.toString() + " X Button ID");
        Log.d("ViewExerciseList", view.getId() + " X Button ID");
        Toast.makeText(ViewExerciseList.this, text, Toast.LENGTH_LONG).show();
    }

    private void loadCallBackListener() {
        exerciseListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        long viewId = view.getId();

                        if (viewId == R.id.removeExButton) {
                            //Toast.makeText(ViewExerciseList.this, "Item removed", Toast.LENGTH_SHORT).show();
                            String exName = String.valueOf(parent.getItemAtPosition(position));
                            deleteConfirmPopup(exName);
                        } else if (viewId == R.id.exNameTextView) {
                            String item = String.valueOf(parent.getItemAtPosition(position));
                            viewExercise(item);
                        }
                    }
                }
        );
    }

    /**
     * Checks database for type of exercise then calls view on exercise to match
     * @param item
     */
    public void viewExercise(String item) {
        String type = dbHelper.exerciseTypeToString(item);
        //TODO load info into ViewType
        if (type.equals("Repetition")) {
            Intent intent = new Intent(ViewExerciseList.this, ViewType.class);
            intent.putExtra("ExerciseName", item);
            startActivity(intent);

        } else if (type.equals("Length")) {
            Intent intent = new Intent(ViewExerciseList.this, ViewType.class);
            intent.putExtra("ExerciseName", item);
            startActivity(intent);
        }

    }


    public void updateView() {
        String[] exNames = dbHelper.exerciseNameToArray();
        ListAdapter adapter = new CustomExerciseViewAdapter(this, exNames);
        exerciseListView.setAdapter(adapter);
    }

    public void deleteConfirmPopup(final String exName) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ViewExerciseList.this);
        alert.setTitle("Alert");
        alert.setMessage("Would you like to delete " + exName);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(ViewExerciseList.this, "Exercise Deleted", Toast.LENGTH_SHORT).show();
                dbHelper.deleteExerciseByID(dbHelper.exerciseNameToID(exName));
                updateView();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(ViewExerciseList.this, "Item not removed", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();

    }
}




