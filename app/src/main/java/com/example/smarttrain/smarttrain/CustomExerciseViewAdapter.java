package com.example.smarttrain.smarttrain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * This is the middle setting up the exercise view for building a workout
 * Takes exerciseID and returns the name in a custom view
 *
 * @author     Kelsey Hyde and Mike Nicholls
 * @version    1.0 (2015)
 */
class CustomExerciseViewAdapter extends ArrayAdapter<String> {

    DBHelper db;


    public CustomExerciseViewAdapter(Context context, String[] exerciseIDs) {
        super(context, R.layout.custom_view_exercise_name, exerciseIDs);
        db = new DBHelper(context);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        final View customView = layoutInflater.inflate(R.layout.custom_view_exercise_name, parent, false);
        String singleID = getItem(position);
        TextView exerciseNameTextView = (TextView) customView.findViewById(R.id.exNameTextView);
        exerciseNameTextView.setText(singleID);

        Button button1 = (Button) customView.findViewById(R.id.removeExButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) parent).performItemClick(v, position, 0); // Let the event be handled in onItemClick()
            }
        });

        TextView exNameTextView = (TextView) customView.findViewById(R.id.exNameTextView);
        exNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) parent).performItemClick(v, position, 0); // Let the event be handled in onItemClick()
            }
        });







        return customView;
    }




}
