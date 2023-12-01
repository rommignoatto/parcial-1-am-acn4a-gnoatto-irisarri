package com.example.myapplicationwardieretravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button buyButtonLondon;
    Button buyButtonBarcelona;
    Button buyButtonParis;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buyButtonLondon = findViewById(R.id.buyButton);
        buyButtonBarcelona = findViewById(R.id.buyButtonBarcelona);
        buyButtonParis = findViewById(R.id.buyButtonParis);



    }
    public void openActivityHotel(View view){
        Intent intent = new Intent(this, MainActivityHoteles.class);
        startActivity(intent);

    }

    public void openActivityParis(View view){
        Intent intent = new Intent(this, MainActivityParis.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.header_menu, menu);

        MenuItem profileItem = menu.findItem(R.id.marca);
        View actionView = profileItem.getActionView();

        if (actionView != null) {
            ImageView profileIcon = actionView.findViewById(R.id.marca);

            TextView profileText = actionView.findViewById(R.id.perfil);
        }

        return true;
    }

    public void buyLondon(View v){
        buyButtonLondon.setText("Comprado");
        buyButtonLondon.setEnabled(false);
        buyButtonLondon.setBackgroundColor(getResources().getColor(R.color.comprado));
        Toast.makeText(this, "Compraste paquete Londres histórica", Toast.LENGTH_SHORT).show();
    }
    public void buyBarcelona(View v){
        buyButtonBarcelona.setText("Comprado");
        buyButtonBarcelona.setEnabled(false);
        buyButtonBarcelona.setBackgroundColor(getResources().getColor(R.color.comprado));
        Toast.makeText(this, "Compraste paquete Barcelona Gaudi", Toast.LENGTH_SHORT).show();
    }
    public void buyParis(View v){
        buyButtonParis.setText("Comprado");
        buyButtonParis.setEnabled(false);
        buyButtonParis.setBackgroundColor(getResources().getColor(R.color.comprado));
        Toast.makeText(this, "Compraste paquete Paris soñada", Toast.LENGTH_SHORT).show();
    }



}
