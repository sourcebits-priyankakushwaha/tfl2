package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RouteListAdapter  extends ArrayAdapter<RouteListModelClass> {

    private List<RouteListModelClass> routeObjects;


    Context context;
    String durationArray[];
    String startArray[];
    String endArray[];
    TextView tv_duration;
    TextView tv_start;
    TextView tv_end;

    public RouteListAdapter(Context context, int textViewResourceId, ArrayList<RouteListModelClass> routeObjects) {

        super(context, textViewResourceId, routeObjects);
        this.routeObjects = routeObjects;
    }

    //Layout inflater is used for convert xml object to java object
    //row is a object which contains Relative layout (parent of the image and text view)
    // by using row object we are fetching imageview and textview
    //getview method is called each time for each row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.journey_planner_route_list_single_row, null);
        }


        RouteListModelClass i = routeObjects.get(position);

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            tv_duration = (TextView) v.findViewById(R.id.tv_duration);
            tv_start = (TextView) v.findViewById(R.id.tv_start);
            tv_end = (TextView) v.findViewById(R.id.tv_end);

            //set the value in textbox
            tv_duration.setText(i.getDuration());
            tv_start.setText(i.getStartDateTime());
            tv_end.setText(i.getEndDateTime());



            // check to see if each individual textview is null.
            // if not, assign some text!
      /*  if (tt != null){
            tt.setText("Name: ");
        }
        if (ttd != null){
            ttd.setText(i.getName());
        }
        if (mt != null){
            mt.setText("Price: ");
        }
        if (mtd != null){
            mtd.setText("$" + i.getPrice());
        }
        if (bt != null){
            bt.setText("Details: ");
        }
        if (btd != null){
            btd.setText(i.getDetails());
        }
    } */
        }
        // the view must be returned to our activity
        return v;

    }
}
