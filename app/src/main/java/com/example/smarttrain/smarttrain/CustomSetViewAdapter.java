package com.example.smarttrain.smarttrain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mike on 13/09/2015.
 */
class CustomSetViewAdapter extends ArrayAdapter<Set> {


    public CustomSetViewAdapter(Context context, ArrayList<Set> sets) {
        super(context, R.layout.custom_view_sets, sets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_view_sets, parent, false);

        Set singleSet = getItem(position);

        TextView setNumberTextView = (TextView) customView.findViewById(R.id.setNumberTextView);
        TextView targetRepsNumberTextView = (TextView) customView.findViewById(R.id.targetRepsNumberTextView);
        TextView targetWeightNumberTextView = (TextView) customView.findViewById(R.id.targetWeightNumberTextView);

        setNumberTextView.setText("Set " + Integer.toString(position + 1));
        targetRepsNumberTextView.setText(Integer.toString(singleSet.getRepetitions()));
        targetWeightNumberTextView.setText(Double.toString(singleSet.getWeight()));

        return customView;

    }
}
