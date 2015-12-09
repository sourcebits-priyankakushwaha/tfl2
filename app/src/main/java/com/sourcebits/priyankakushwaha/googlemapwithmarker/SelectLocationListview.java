package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectLocationListview extends Activity implements AdapterView.OnItemClickListener {

    ListView listView;
    String Title[] = {"London Eye" , "Westminister" , "Bank" , "Big Ben", "Chelsea", "Black Pool", "Wembley Stadium", "Emirates Stadium", "Tottenham"};
    TravelData travelData ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.third_screen_single_row,R.id.tv_place_name, Title);

        listView = (ListView) findViewById(R.id.location_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen);
        locationList = (ListView) findViewById(R.id.location_list);
        myAdapter adapter = new myAdapter(this, Title);// pass the array of the locations
        locationList.setAdapter(adapter);
    }

    class myAdapter extends ArrayAdapter<String> {
        Context context;
        public String titleArray[];


        public myAdapter(Context c, String titles[]) //taking title as a parameter
        {
            super(c, R.layout.third_screen_single_row);
            this.context = c;
            this.titleArray = titles;

        }
        //Layout inflater is used for convert xml object to java object
        //row is a object which contains Relative layout (parent of the image and text view)
        // by using row object we are fetching textview
        //getview method is called each time for each row
       @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.third_screen_single_row, parent, false);
            TextView myTitle = (TextView) row.findViewById(R.id.tv_place_name);
            myTitle.setText(titleArray[position]);
            return row;// this is the final view we want
        } }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent returnIntent = getIntent();
        returnIntent.putExtra("position", position);
        String itemValue = (String) listView.getItemAtPosition(position);
        returnIntent.putExtra("resultValue", itemValue);
        // returnIntent.putExtra("Loaction", );
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}


