package com.example.myapplicationwardieretravel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class guiadownloaderlondres extends AsyncTask<String, Integer, Bitmap> {
    private Bitmap guiaDescargada = null;

    private ImageView imageView;

    public guiadownloaderlondres(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String URL_consulta = strings[0];
        try{
            URL consulta = new URL(URL_consulta);
            InputStream contenido = (InputStream) consulta.getContent();
            this.guiaDescargada = BitmapFactory.decodeStream(contenido);
        }catch (Exception e){
            e.printStackTrace();
        }
        return guiaDescargada;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(guiaDescargada ==null) return;

        this.imageView.setImageBitmap(bitmap);
    }
}
