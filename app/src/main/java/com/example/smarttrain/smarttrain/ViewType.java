package com.example.smarttrain.smarttrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ViewType extends AppCompatActivity {

    DBHelper dbHelper;
    static final String unitText = "This exercise is measured in ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_type);



        dbHelper = new DBHelper(this);
        Intent i = getIntent();
        String exName = i.getStringExtra("ExerciseName");
        TextView exNameTextView = (TextView) findViewById(R.id.exNameTextView);
        TextView exDescriptionTextView = (TextView) findViewById(R.id.exDescriptionTextView);
        exNameTextView.setText(exName);
        exDescriptionTextView.setText(dbHelper.getDescriptionByName(exName));
        TextView unitsTextView = (TextView) findViewById(R.id.unitsTextView);
        unitsTextView.setText(unitText + dbHelper.exerciseTypeToString(exName));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_type, menu);
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
