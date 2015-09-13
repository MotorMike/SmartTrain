package com.example.smarttrain.smarttrain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Mike on 13/09/2015.
 */
class CustomSetViewAdapter extends ArrayAdapter<String>{
    public CustomSetViewAdapter(Context context, String[] resource) {
        super(context,R.layout.custom_view_sets ,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_view_sets, parent, false);

        String singleSet = getItem(position);
        TextView set = (TextView) customView.findViewById(R.id.setNumbertextView);


        set.setText(singleSet);
        return customView;

    }
}
