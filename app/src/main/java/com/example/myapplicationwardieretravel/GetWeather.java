package com.example.myapplicationwardieretravel;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetWeather extends AsyncTask<String, Integer, String> {
    private Context context;

    public GetWeather(Context context){
        this.context = context;
    }
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];

        String temperaturaMarzo = "";
        try {
            String response = run(url);
            JSONObject clima = new JSONObject(response);
           JSONObject paris = clima.getJSONObject("paris");
           int temperaturaMarzoint = paris.getInt("marzo");
           temperaturaMarzo = String.valueOf(temperaturaMarzoint);
            Log.i("GetWeather", "Temperatura de marzo en París: " + temperaturaMarzo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return temperaturaMarzo;
    }

    @Override
    protected void onPostExecute(String temperaturaMarzo) {
        super.onPostExecute(temperaturaMarzo);
        TextView textViewTemperatura = ((Activity) context).findViewById(R.id.textViewTemperatura);
        textViewTemperatura.setText("Temperatura promedio: "+ temperaturaMarzo+ "°C");
        Log.i("probando_url", temperaturaMarzo);
    }
}
