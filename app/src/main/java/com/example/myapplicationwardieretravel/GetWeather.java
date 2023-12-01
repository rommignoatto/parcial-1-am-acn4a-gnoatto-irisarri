package com.example.myapplicationwardieretravel;

import android.os.AsyncTask;
import android.util.Log;

public class GetWeather extends AsyncTask<String, Integer, String> {
    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        return url;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("probando_url", s);
    }
}
