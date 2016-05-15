package com.erra.sean.watchdog;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by sean on 5/15/16.
 */
public class PinSubmitActivity extends AsyncTask<String, Void, String> {

    private Context context;

    public PinSubmitActivity(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        String lat = arg0[0];
        String lng = arg0[1];
        String sdf = arg0[2];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?latitude=" + URLEncoder.encode(lat, "UTF-8");
            data += "&longitude=" + URLEncoder.encode(lng, "UTF-8");
            data += "&datetime=" + URLEncoder.encode(sdf, "UTF-8");

            link = "http://178.62.68.173/pinsert.php" + data;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, "Pin submitted successfully.", Toast.LENGTH_SHORT).show();
    }
}
