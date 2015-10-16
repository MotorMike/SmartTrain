package com.example.smarttrain.smarttrain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This is the used for setting up the custom view set builder
 *
 * @author Kelsey Hyde and Mike Nicholls
 * @version 1.0 (2015)
 */
class CustomSetBuildAdapter extends ArrayAdapter<Set> {

    ArrayList<Set> setsArray;
    Context ctxt;
    LayoutInflater thisInflater;
    int counter = 0;


    /*public CustomSetBuildAdapter(Context context, ArrayList<Set> list) {
        super(context, R.layout.custom_view_set_builder, list);

    }*/

    public CustomSetBuildAdapter(Context c, ArrayList al) {
        super(c, R.layout.custom_view_set_builder, al);
        ctxt = c;
        setsArray = al;
        thisInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

   /* public CustomSetBuildAdapter(Context context, List<Set> objects) {
        super(context, resource, objects);
    }*/


    @Override
    public int getCount() {
        return setsArray.size();
    }

    @Override
    public Set getItem(int position) {
        return setsArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = thisInflater.inflate(R.layout.custom_view_set_builder, parent, false);
        }

        Set singleSet = getItem(position);
        if (singleSet != null) {

            TextView setNumber = (TextView) convertView.findViewById(R.id.setNumberTextView2);
            String positionString = String.valueOf(position + 1);
            setNumber.setText(positionString);

            EditText repTarEditText = (EditText) convertView.findViewById(R.id.repTarEditText);
            repTarEditText.setText((String.valueOf(singleSet.getRepetitions())));

            EditText weightTarEditText = (EditText) convertView.findViewById(R.id.weightTarEditText);
            weightTarEditText.setText((String.valueOf(singleSet.getWeight())));


            return convertView;
        }
        return convertView;
    }


}


