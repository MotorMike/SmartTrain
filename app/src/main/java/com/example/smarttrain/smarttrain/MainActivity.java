package com.example.smarttrain.smarttrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * This would be considered the main class in a java only program
 * used to display a UI and link to other pages
 * Will later be used for background notifications
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void createButtonOnClick(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    public void trackButtonOnClick(View view) {
        Intent intent = new Intent(this, TrackActivity.class);
        startActivity(intent);
    }

    public void progressButtonOnClick(View view) {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }

    public void profileButtonOnClick(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    //Intent intent = new Intent(this,ProfileActivity.class);
    public void todayButtonOnClick(View view) {
        //startActivity(intent);
        CharSequence text = "Button not implemented";
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();

    }


}
