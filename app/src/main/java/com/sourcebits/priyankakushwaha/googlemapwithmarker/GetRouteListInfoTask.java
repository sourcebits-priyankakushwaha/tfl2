package com.sourcebits.priyankakushwaha.googlemapwithmarker;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetRouteListInfoTask  extends AsyncTask<String[], Void, List<RouteListModelClass>> {
    private RouteListActivity activity;
    private String url;
   // private XmlPullParserFactory xmlFactoryObject;
    private ProgressDialog pDialog;

    public GetRouteListInfoTask(RouteListActivity activity, String url) {
        this.activity = activity;
        this.url = url;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setTitle("Get route list from JSON");
        pDialog.setMessage("Loading...");
        pDialog.show();
    }

    @Override
    protected List<RouteListModelClass> doInBackground(String[]... params) {
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000 /* milliseconds */);
            connection.setConnectTimeout(15000 /* milliseconds */);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            InputStream stream = connection.getInputStream();
            List<RouteListModelClass> routeListResult = parseJSON();
            stream.close();
            return routeListResult;

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("AsyncTask", "exception");
            return null;
        }
    }

    private List<RouteListModelClass> parseJSON() {


        return null;
    }

    @Override
    protected void onPostExecute(List<RouteListModelClass> result) {
        //call back data to main thread
        pDialog.dismiss();
        activity.callBackDataForRoute(result);

    }
}
