package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class SecondActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button bFrom;
    private Button bTo;
    private Button bTravelPref;
    private Button bFindRoute;
    Button btnCalendar, btnTimePicker;
    EditText txtDate, txtTime;
    TextView tv_from, tv_to, tv_travel_pref;
    // TravelData travelData;
    TravelData travelData;


    // Variable for storing current date and time
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        bFrom = (Button) findViewById(R.id.btn_from);
        bTo = (Button) findViewById(R.id.btn_to);
        bFindRoute = (Button) findViewById(R.id.btn_find_route);
        //bTravelPref = (Button) findViewById(R.id.btn_travel_pref);

        btnCalendar = (Button) findViewById(R.id.btnCalendar);
        btnTimePicker = (Button) findViewById(R.id.btnTimePicker);

        txtDate = (EditText) findViewById(R.id.txtDate);
        txtTime = (EditText) findViewById(R.id.txtTime);

        btnCalendar.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        bFrom.setOnClickListener(this);
        bTo.setOnClickListener(this);
        bFindRoute.setOnClickListener(this);
       // bTravelPref.setOnClickListener(this);
        // select Location Type
        Spinner locTypeSpinner = (Spinner) findViewById(R.id.loc_type);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> locAdapter = ArrayAdapter
                .createFromResource(this, R.array.location_type_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        locAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        locTypeSpinner.setAdapter(locAdapter);

        //get the result from previous screen
        Intent intent = getIntent();
        String from_location = intent.getStringExtra("Location Name"); // using key fetch the location value
        tv_from = (TextView) findViewById(R.id.from);
        tv_from.setText(from_location);//Set the result in textview

    }

    public void onClick(View view) {
        if (view == bFrom) {

            Intent fromIntent = new Intent(this, SelectLocationListview.class);
            startActivityForResult(fromIntent, 0);

        }

        if (view == bTo) {
            Intent toIntent = new Intent(this, SelectLocationListview.class);
            startActivityForResult(toIntent, 1);
        }

        if (view == btnCalendar) {
            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            txtDate.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            dpd.show();

        }

        if (view == btnTimePicker) {

            // Process to get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // Display Selected time in textbox
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            tpd.show();
        }

      /* if (view == bTravelPref) {

            Intent TravelPrefIntent = new Intent(this, TravelPreferenceActivity.class);
            startActivityForResult(TravelPrefIntent, 2);

        }*/

        if (view == bFindRoute) {
            Intent findRouteIntent = new Intent(this, RouteListActivity.class);
            String putFrom = travelData.getFrom();
            findRouteIntent.putExtra("From", putFrom);
            String putTo = travelData.getTo();
            findRouteIntent.putExtra("To", putTo);
            String putDate = txtDate.getText().toString();
            findRouteIntent.putExtra("Date", putDate);
            String puttime = txtTime.getText().toString();
            findRouteIntent.putExtra("Time", puttime);
           // findRouteIntent.putExtra("TavelPref", travelData.getTavelPref());
            startActivity(findRouteIntent);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.v("item", (String) parent.getItemAtPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {

            if (resultCode == Activity.RESULT_OK) {

                Bundle bundle = data.getExtras();
                String fromName = bundle.getString("resultValue");
                travelData = new TravelData(fromName, null, null, null);
                travelData.setFrom(fromName);
                //set the value of from location
                // String res =  travelData.getFrom() ;
                // Log.d("value","res");
                tv_from = (TextView) findViewById(R.id.from);
                tv_from.setText(travelData.getFrom());//Set the result in textview


            }

        } else if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                Bundle bundle = data.getExtras();
                String toName = bundle.getString("resultValue");

                travelData = new TravelData(null, toName, null, null);
                travelData.setFrom(toName);
                //set the value of to location
                travelData.setTo(toName);
                tv_to = (TextView) findViewById(R.id.to);
                tv_to.setText(travelData.getTo());//Set the result in textview

            }

        } /*else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {

                Bundle bundle = data.getExtras();
                String travelPref = bundle.getString("resultValue");
                //set the value of from location
                travelData.setTavelPref(travelPref);
                tv_travel_pref = (TextView) findViewById(R.id.tv_travel_pref);
                tv_travel_pref.setText(travelPref);//Set the result in textview


            }

        }*/
    }
}
