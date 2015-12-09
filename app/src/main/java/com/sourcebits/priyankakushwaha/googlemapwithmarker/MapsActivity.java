package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.support.v4.app.Fragment;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

@SuppressWarnings("ALL")
public class MapsActivity extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    @SuppressWarnings("FieldCanBeLocal")
    private GoogleMap map ;
    public LocationDB db = new LocationDB(getActivity());
    private static String LOG_TAG = "MapsActivity";

    // intialize marker variable
    private Marker m1, m2, m3, m4, m5, m6, m7, m8;
    //  private MapFragment mapFragment;
    static View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(rootView==null){
            rootView = (LinearLayout)inflater.inflate(R.layout.activity_maps, container, false);

            getMapAsync(this );
        }
        return rootView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

 /*    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        insertRows();
    } */

  private void insertRows() {
        /**
         * CRUD Operations
         * */
        // Inserting Locations
        Log.d(LOG_TAG, "Insert: Inserting .. STARTED");
        db.insertLocation(new LatLongPlaces("SW1A 2AX", 51.504981, -0.127262, "Horseguard Parade, Whitehall, London, SW1A 2AX", "HORSE GUARDS PARADE (SW1)", "1"));
        db.insertLocation(new LatLongPlaces("SE10 0DX", 51.501571, 0.005532, "The O2, Peninsula Square, London, SE10 0DX", "The O2", "1"));
        db.insertLocation(new LatLongPlaces("W1B 1JA", 51.51772625174497, -0.14411509037017822, "The Langham Hotel, 1C Portland Pl, Westminster, London, W1B 1JA", "GRANGE LANGHAM COURT HOTEL", "1"));
        db.insertLocation(new LatLongPlaces("E16 1XL", 51.50816, 0.02712, "ExCel, One Western Gateway, Royal Victoria Dock, London, E16 1XL", "BRITANNIA COLLEGE OF EXCELLENCE", "1"));
        db.insertLocation(new LatLongPlaces("E20 2ST", 51.53854140853689, -0.016543865203857422, "Olympic Park, Stratford, London, E20 2ST", "OLYMPIC CAFE", "1"));
        db.insertLocation(new LatLongPlaces("WC1B 3DG", 51.51897, -0.1265, "BRITISH MUSEUM, Great Russell Street, London, WC1B 3DG", "BRITISH MUSEUM", "2"));
        db.insertLocation(new LatLongPlaces("EC4M 8", 51.513897256014594, -0.0986623764038086, "ST.PAULS CATHEDRAL, Saint Pauls Church Yard, City of London, London,EC4M 8", "ST PAULS CATHEDRAL SCHOOL", "2"));
        db.insertLocation(new LatLongPlaces("'EC3N 4AB", 51.508602, -0.076013, "TOWER OF LONDON / CROWN JEWELS, Tower Hill, London, EC3N 4AB", "BANNATYNES HEALTH CLUB TOWER 42, CITY OF LONDON", "2"));
        Log.d(LOG_TAG, "Insert: Inserting .. END");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMyLocationEnabled(true);
        m1 = map.addMarker(new MarkerOptions()
                .position(new LatLng(51.504981, -0.127262))
                .title("HORSE GUARDS PARADE (SW1)"));

        m2 = map.addMarker(new MarkerOptions()
                .position(new LatLng(51.501571, 0.005532))
                .title("The O2"));

        m3 = map.addMarker(new MarkerOptions()
                .position(new LatLng(51.51772625174497, -0.14411509037017822))
                .title("GRANGE LANGHAM COURT HOTEL"));

        m4 = map.addMarker(new MarkerOptions()
                .position(new LatLng(51.50816, 0.02712))
                .title("BRITANNIA COLLEGE OF EXCELLENCE"));

        m5 = map.addMarker(new MarkerOptions()
                .position(new LatLng(51.53854140853689, -0.016543865203857422))
                .title("OLYMPIC CAFE"));

        m6 = map.addMarker(new MarkerOptions()
                .position(new LatLng(51.51897, -0.1265))
                .title("BRITISH MUSEUM"));

        m7 = map.addMarker(new MarkerOptions()
                .position(new LatLng(51.513897256014594, -0.0986623764038086))
                .title("ST PAULS CATHEDRAL SCHOOL"));

        m8 = map.addMarker(new MarkerOptions()
                .position(new LatLng(51.508602, -0.076013))
                .title("BANNATYNES HEALTH CLUB TOWER 42, CITY OF LONDON"));


        //make marker clickable
        map.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(m1)) {
            Intent nextIntent = new Intent(getActivity(), SecondActivity.class);
            nextIntent.putExtra("Location Name",m1.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m2)) {
            Intent nextIntent = new Intent(getActivity(), SecondActivity.class);
            nextIntent.putExtra("Location Name",m2.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m3)) {
            Intent nextIntent = new Intent(getActivity(), SecondActivity.class);
            nextIntent.putExtra("Location Name",m3.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m4)) {
            Intent nextIntent = new Intent(getActivity(), SecondActivity.class);
            nextIntent.putExtra("Location Name",m4.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m5)) {
            Intent nextIntent = new Intent(getActivity(), SecondActivity.class);
            nextIntent.putExtra("Location Name",m5.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m6)) {
            Intent nextIntent = new Intent(getActivity(), SecondActivity.class);
            nextIntent.putExtra("Location Name",m6.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m7)) {
            Intent nextIntent = new Intent(getActivity(), SecondActivity.class);
            nextIntent.putExtra("Location Name",m7.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m8)) {
            Intent nextIntent = new Intent(getActivity(), SecondActivity.class);
            nextIntent.putExtra("Location Name",m8.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }

        return false;
    }
}












   /*   //customizing the marker using bitmapdescriptorfactory
    View marker = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker, null);
    TextView Loaction = (TextView) marker.findViewById(R.id.loc_tv);
    Loaction.setText(titleName[i]);

//                map.addMarker(new MarkerOptions()
//                        .position(new LatLng(latitude[i], longitude[i]))//we are giving static lat long
//                        .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));
    // Convert a view to bitmap
public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);

        //left, top , right , bottom
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ALPHA_8);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }*/

