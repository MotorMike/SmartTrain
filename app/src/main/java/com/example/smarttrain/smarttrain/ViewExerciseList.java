package com.example.smarttrain.smarttrain;

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

        String[] exNames = dbHelper.exerciseNameToArray();
        ListAdapter adapter = new CustomExerciseViewAdapter(this, exNames);
        exerciseListView.setAdapter(adapter);


        exerciseListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(position));
                        Object object = parent.getItemAtPosition(position);

                        Log.d("ViewExerciseList", "Onclick lister item is: " + item);
                        Toast.makeText(ViewExerciseList.this, item, Toast.LENGTH_SHORT).show();

                        // TODO View exercise here
                    }
                }
        );


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

}
