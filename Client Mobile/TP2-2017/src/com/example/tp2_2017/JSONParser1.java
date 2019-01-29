package com.example.tp2_2017;

import android.os.AsyncTask;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DELL on 15/11/2017.
 */

public class JSONParser1 extends AsyncTask<String, Void, String> {

    static InputStream is = null;

    static JSONObject jObj = null;
    static JSONArray jArray = null;
    static String json = "";

    @Override
    protected void onPreExecute() {
    }


    // constructor
    public JSONParser1() {

    }

    private static final String TAG = "TestJsonParser";
    @Override
    protected String doInBackground(String... params) {

//String url="http://192.168.1.2:8080/UserManagement/rest/Livre/Livres";

        String url=params[0];
        String responseBody="" ;

        Log.d(TAG, url);
        // Making HTTP request
        try {
            // defaultHttpClient
//            //HttpGet httpPost = new HttpGet(url);

            URL urlObj = new URL(url);



            Log.d(TAG, "Before httpResponse");

            HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
            Log.d(TAG, "after  httpResponse");


            final int statusCode = urlConnection.getResponseCode();
            Log.d(TAG, "after statusCode, code= " +statusCode);

            Log.d(TAG, "Input Stream");
           is = urlConnection.getInputStream();

            //HttpResponse getResponse = httpClient.execute(httpPost);
            Log.d(TAG, "After httpResponse");

            if (statusCode != 200) {
                Log.w(getClass().getSimpleName(),
                        "Error " + statusCode + " for URL " + url);
                return null;
            }
            Log.v("AsynchTask", "= getResponse.getEntity();");





            Log.v("AsynchTask", "getResponseEntity.getContent(); ");


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.v("AsynchTask", "ERROR1");}
         catch (IOException e) {
            Log.d("IO", e.getMessage().toString());
            Log.v("AsynchTask", "ERROR3");
            e.printStackTrace();

        }
        catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        try {
            Log.v("AsynchTask", "lire données");
            BufferedReader reader = new BufferedReader(new InputStreamReader( is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }


        // return JSON String



       // return jArray.toString();
        return json;



    }
    protected void onPostExecute(String page)
    {
        //onPostExecute
    }
}
