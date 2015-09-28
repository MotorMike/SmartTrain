package com.example.smarttrain.smarttrain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Mike on 24/09/2015.
 * This is the middle setting up the exercise view for building a workout
 * Takes exerciseID and returns the name in a custom view
 */
class CustomExerciseViewAdapter extends ArrayAdapter<String> {

    DBHelper db;


    public CustomExerciseViewAdapter(Context context, String[] exerciseIDs) {
        super(context, R.layout.custom_view_exercise_name, exerciseIDs);
        db = new DBHelper(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_view_exercise_name, parent, false);

        String singleID = getItem(position);
        String exerciseID = db.exerciseIDtoName(Integer.parseInt(singleID));
        TextView exerciseIDTextView = (TextView) customView.findViewById(R.id.exerciseIDTextView);
        TextView exerciseNameTextView = (TextView) customView.findViewById(R.id.exerciseNameTextView);


        exerciseIDTextView.setText(singleID);
        exerciseNameTextView.setText(exerciseID);

        return customView;
    }
}
