package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LocationDB extends SQLiteOpenHelper {

    /**
     * Database name
     */
    private static String DATABASE_NAME = "locationDB";

    /**
     * Version number of the database
     */
    private static int DATABASE_VERSION = 2;
    public static final String LOC_ID = "_id";
    public static final String LOC_POSTAL_CODE = "postcode";
    public static final String LOC_LATITUDE = "lat";
    public static final String LOC_LONGITUDE = "long";
    public static final String LOC_ADDRESS = "adrs";
    public static final String LOC_TITLE = "title";
    public static final String LOC_TYPE = "type";


    /**
     * A constant, stores the the table name
     */
    private static final String TABLE_NAME = "locationTable";

    public LocationDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
                LOC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                LOC_POSTAL_CODE + " TEXT ," +
                LOC_LATITUDE + " DOUBLE , " +
                LOC_LONGITUDE + " DOUBLE , " +
                LOC_ADDRESS + " TEXT , " +
                LOC_TITLE + " TEXT , " +
                LOC_TYPE + " TEXT " +
                " ) ";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    // Adding new loc
    void insertLocation(LatLongPlaces latlng) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        LatLongPlaces latlong=new LatLongPlaces();

//        ContentValues[] mValueArray = new ContentValues[getLocationCount()];
//        List<ContentValues>mValueList = new ArrayList<ContentValues>();
        ContentValues mNewValues = new ContentValues();

        //ContentValues values [] = new ContentValues[getLocationCount()];
        mNewValues.put(LOC_POSTAL_CODE, latlng.get_postcode());
        mNewValues.put(LOC_LATITUDE, latlng.get_lat());
        mNewValues.put(LOC_LONGITUDE, latlng.get_lng());
        mNewValues.put(LOC_ADDRESS, latlng.get_adrs());
        mNewValues.put(LOC_TITLE, latlng.get_title());
        mNewValues.put(LOC_TYPE, latlng.get_type());

        // Inserting RoW
       long rowId =  db.insert(TABLE_NAME, null, mNewValues);
        Log.d("Inserted value",String.valueOf(rowId));
       // mNewValues.clear();
        //break;

        // Closing database connection
        db.endTransaction();
        db.close();
    }

    // Getting All Loactions
    public List<LatLongPlaces> getAllLocations() {
        List<LatLongPlaces> placesList = new ArrayList<LatLongPlaces>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                LatLongPlaces latlng = new LatLongPlaces();
                latlng.set_id(Integer.parseInt(cursor.getString(0)));
                latlng.set_postcode(cursor.getString(1));
                latlng.set_lat(Double.valueOf(cursor.getString(2)));
                latlng.set_lng(Double.valueOf(cursor.getString(3)));
                latlng.set_adrs(cursor.getString(4));
                latlng.set_title(cursor.getString(5));
                latlng.set_type(cursor.getString(6));
                // Adding location to list
                placesList.add(latlng);
            } while (cursor.moveToNext());
        }
        // return contact list
        return placesList;
    }


    // Getting Location Count
    public int getLocationCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int numOfRows = cursor.getCount();
        cursor.close();
        return numOfRows;
    }

}
