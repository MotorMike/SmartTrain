package com.example.smarttrain.smarttrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
/**
 * Has UI
 * Displays basic info for repetition based exercise
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
public class ViewRepetition extends AppCompatActivity {
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_repetition);

        dbHelper = new DBHelper(this);

        Intent i = getIntent();
        String exName = i.getStringExtra("ExerciseName");
        TextView exNameTextView = (TextView) findViewById(R.id.exNameTextView);
        TextView exDescriptionTextView = (TextView) findViewById(R.id.exDescriptionTextView);
        exNameTextView.setText(exName);
        exDescriptionTextView.setText(dbHelper.getDescriptionByName(exName));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_repetition, menu);
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
