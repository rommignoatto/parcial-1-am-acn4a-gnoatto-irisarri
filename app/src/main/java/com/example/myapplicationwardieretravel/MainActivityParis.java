package com.example.myapplicationwardieretravel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivityParis extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paris);
        ImageView imageView = (ImageView) findViewById(R.id.imageViewParis6);
        imageView.setOnClickListener(this);
    }



    public void onClick(View view){

        if (view.getId() == R.id.imageViewParis6) {
            descargaPDF();
        }
    }

    void descargaPDF(){
        String urlADescargar = "https://drive.google.com/file/d/1x4OEFh59gThNiFU8Ob46NJs1RR8wGPHT/view";
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Descargando Guía...");

        new MainActivityParis.DescargarPDFAsyncTask(progressDialog).execute(urlADescargar);
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