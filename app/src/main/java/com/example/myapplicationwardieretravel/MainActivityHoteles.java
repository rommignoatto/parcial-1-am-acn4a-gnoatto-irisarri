package com.example.myapplicationwardieretravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivityHoteles extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hoteles);
        Intent intent = this.getIntent();
        String nuevoHotel = null;
        if(intent.hasExtra(nuevoHotel)){
            Log.i("mensaaje","llego el dato bien");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView6);
        imageView.setOnClickListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }

    public void onClick(View view){

        if (view.getId() == R.id.imageView6) {
            descargaPDF();
        }
    }

    void descargaPDF(){
        String urlADescargar = "https://drive.google.com/file/d/19cbnxCqfe7oyN3HfOywqMv3u-xSm8zaE/view?pli=1";
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Descargando Guía...");
        
        new DescargarPDFAsyncTask(progressDialog).execute(urlADescargar);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng hotelLondres = new LatLng(51.4923356,-0.1433639);
        mMap.addMarker(new MarkerOptions().position(hotelLondres).title("Chester Hotel Victoria"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hotelLondres));
    }




    class DescargarPDFAsyncTask extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        public DescargarPDFAsyncTask(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... urlPDF) {
            String urlADescargar = urlPDF[0];

            HttpURLConnection conexion = null;
            InputStream input = null;
            OutputStream output = null;

            try{
                URL url = new URL(urlADescargar);

                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if(conexion.getResponseCode()!= HttpURLConnection.HTTP_OK){
                    return "Problemas de conexión";
                }
                input = conexion.getInputStream();
                String rutaGuardado = getFilesDir() + "/Guias.pdf";
                output = new FileOutputStream(rutaGuardado);

                byte[] data = new byte[1024];
                int count;
                while((count = input.read(data)) != -1){

                    output.write(data, 0, count);
                }

            }catch(MalformedURLException e){
                e.printStackTrace();
                return "Error" + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Error" + e.getMessage();
            }finally{
                try{
                    if(input!=null) input.close();
                    if(output!=null) output.close();
                    if(conexion!=null) conexion.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            Log.i("mensaje:","Se realiza descarga");
            return "Descarga realizada correctamente";
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Descarga Realizada", Toast.LENGTH_SHORT).show();
        }
    }
}