package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TravelPreferenceActivity extends Activity implements AdapterView.OnItemSelectedListener {
    Spinner travelPrefSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        travelPrefSpinner = (Spinner) findViewById(R.id.loc_type);
        //String mStr = travelPrefSpinner.getSelectedItem().toString();

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> travelPrefAdapter = ArrayAdapter
                .createFromResource(this, R.array.travel_pref_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        travelPrefAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        travelPrefSpinner.setAdapter(travelPrefAdapter);
        travelPrefSpinner.setOnItemSelectedListener(this);
}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Intent returnIntent = getIntent();
        String itemValue = (String)  travelPrefSpinner.getItemAtPosition(position);
        //String mStr = travelPrefSpinner.getSelectedItem().toString();
        returnIntent.putExtra("resultValue", itemValue);
        // returnIntent.putExtra("Loaction", );
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
